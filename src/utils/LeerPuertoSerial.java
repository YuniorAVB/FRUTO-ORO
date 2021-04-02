package utils;

import config.MensajeError;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LeerPuertoSerial implements Runnable, SerialPortEventListener {

    private SerialPort serialPort;
    private String st;
    private InputStream input;
    private OutputStream output;
    public char[] c;
    private final int TIME_OUT = 1000;
    private final int DATA_RATE = 9600;
    public static JLabel labelSetData;
    public static Thread t;

    public LeerPuertoSerial(JLabel labelSetData) {
        LeerPuertoSerial.labelSetData = labelSetData;
    }

    public void getPorts() {

        boolean estado = false;

        try {
            CommPortIdentifier portId = null;

            Enumeration<?> puerto = CommPortIdentifier.getPortIdentifiers();

            while (puerto.hasMoreElements()) {
                portId = (CommPortIdentifier) puerto.nextElement();

                if (portId.getName().equals("COM9")) {
                    estado = true;
                }
            }

            if (estado) {

                serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
                serialPort.setSerialPortParams(DATA_RATE,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                input = serialPort.getInputStream();
                output = serialPort.getOutputStream();
                // add event listeners
                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);

            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN LEER EL PURTO");
            }
        } catch (HeadlessException | PortInUseException | TooManyListenersException | IOException | UnsupportedCommOperationException e) {

            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

    }

    public static void setDataPortLabel(JLabel label) {
        LeerPuertoSerial p = new LeerPuertoSerial(label);
        t = new Thread(() -> {
            p.run();
        });

        t.start();
    }

    @Override
    public void run() {
        getPorts();
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {

        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                int available = input.available();
                byte[] chunk = new byte[available];
                input.read(chunk, 0, available);
                st = new String(chunk);
                System.out.print(st);

                labelSetData.setText(st + "KG");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            } catch (IOException ex) {
                Logger.getLogger(LeerPuertoSerial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
