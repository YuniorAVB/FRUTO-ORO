/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.List;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class LeerPuertoSerial implements Runnable, SerialPortEventListener {

    public SerialPort serialPort;
    public String st;
    private InputStream input;
    private OutputStream output;
    public char[] c;
    private final int TIME_OUT = 1000;
    private final int DATA_RATE = 9600;

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
        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        } catch (PortInUseException | TooManyListenersException | IOException | UnsupportedCommOperationException ex) {
            Logger.getLogger(LeerPuertoSerial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        LeerPuertoSerial p = new LeerPuertoSerial();
        Thread t = new Thread(() -> {
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
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            } catch (IOException ex) {
                Logger.getLogger(LeerPuertoSerial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
