package utils;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LecturaSerial {

    CommPortIdentifier portId;
    Enumeration puertos;
    SerialPort serialport;
    InputStream entrada = null;
    Thread t;
    JLabel label;

    public void leerPueto(JLabel label) {

        puertos = CommPortIdentifier.getPortIdentifiers();
        t = new Thread(new LeerSerial(label));
        while (puertos.hasMoreElements()) {
            portId = (CommPortIdentifier) puertos.nextElement();

            if (portId.getName().equalsIgnoreCase("COM2")) {
                try {
                    serialport = (SerialPort) portId.open("LecturaSerial", 250);

                    serialport.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    entrada = serialport.getInputStream();

                    t.start();

                } catch (PortInUseException | IOException | UnsupportedCommOperationException e) {
                    JOptionPane.showMessageDialog(null, "ERROR EN EL PUERTO DE CONEXION DE LA BALANZA");
                }
            }
        }

    }

    public void closePort() {

        this.serialport.close();
        this.t.stop();

    }

    public class LeerSerial implements Runnable {

        public JLabel labelClasePeso;

        public LeerSerial(JLabel labelPeso) {

            labelClasePeso = labelPeso;
        }

        @Override
        public void run() {
            while (true) {
                try {

                    int available = entrada.available();
                    byte[] chunk = new byte[available];
                    entrada.read(chunk, 0, available);
                    String st = new String(chunk);

                    if (st.indexOf("B") > 0) {

                        String[] pesos = st.split("B");

                        if (pesos[1].length() > 6) {

                            String nuevaCadena = "";
                            char[] cadenaSinParsear = pesos[1].toCharArray();
                            for (int i = 0; i < cadenaSinParsear.length; i++) {
                                if (Character.isDigit(cadenaSinParsear[i])) {
                                    nuevaCadena += cadenaSinParsear[i];
                                }
                            }

                            String cadena = nuevaCadena.substring(0, nuevaCadena.length() - 2);
                            labelClasePeso.setText(cadena + "KG");

                        }

                    } else if (st.indexOf("+") > 0) {

                        String[] pesos = st.split("\\+");

                        if (pesos[1].length() > 6) {

                            String nuevaCadena = "";
                            char[] cadenaSinParsear = pesos[1].toCharArray();
                            for (int i = 0; i < cadenaSinParsear.length; i++) {
                                if (Character.isDigit(cadenaSinParsear[i])) {
                                    nuevaCadena += cadenaSinParsear[i];
                                }
                            }
                            String cadena = nuevaCadena.substring(0, nuevaCadena.length() - 3);
                            labelClasePeso.setText(cadena + "KG");

                        }

                    }

                    Thread.sleep(250);

                } catch (IOException | InterruptedException e) {

                    JOptionPane.showMessageDialog(null, "ERROR EN EL PUERTO DE CONEXION DE LA BALANZA");
                }
            }
        }
    }

}


//jtxt_placa_movilidad.setEditable(false);