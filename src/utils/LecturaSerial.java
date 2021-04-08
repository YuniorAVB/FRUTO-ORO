package utils;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LecturaSerial {

    static CommPortIdentifier portId;
    static Enumeration puertos;
    static SerialPort serialport;
    static InputStream entrada = null;
    public static Thread t;
    public static JLabel label;

    public static void leerPueto(JLabel label) {

        puertos = CommPortIdentifier.getPortIdentifiers();
        t = new Thread(new LeerSerial(label));
        while (puertos.hasMoreElements()) {
            portId = (CommPortIdentifier) puertos.nextElement();

            if (portId.getName().equalsIgnoreCase("COM2")) {
                try {
                    serialport = (SerialPort) portId.open("LecturaSerial", 1000);

                    serialport.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    entrada = serialport.getInputStream();

                    t.start();

                } catch (PortInUseException | IOException e) {
                    JOptionPane.showMessageDialog(null, "ERROR EN EL PUERTO DE CONEXION DE LA BALANZA");
                } catch (UnsupportedCommOperationException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR EN EL PUERTO DE CONEXION DE LA BALANZA");
                }
            }
        }
    }

    public static class LeerSerial implements Runnable {

        public static JLabel labelClasePeso;

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

                        if (pesos[1].length() > 6 && pesos[1].indexOf("+") > 0) {

                            String nuevaCadena = pesos[1];
                            nuevaCadena = nuevaCadena.replaceAll("\\+", "");
                            nuevaCadena = nuevaCadena.replaceAll("\\.", "");
                            String cadena = nuevaCadena.substring(0, nuevaCadena.length() - 2);
                            labelClasePeso.setText(cadena + "KG");

                        }

                    } else if (st.indexOf("+") > 0) {

                        String[] pesos = st.split("\\+");

                        if (pesos[1].length() > 6) {

                            String nuevaCadena = pesos[1];
                            nuevaCadena = nuevaCadena.replaceAll("B", "");
                            nuevaCadena = nuevaCadena.replaceAll("\\.", "");
                            String cadena = nuevaCadena.substring(0, nuevaCadena.length() - 2);
                            labelClasePeso.setText(cadena + "KG");

                        }

                    }

                    Thread.sleep(1000);

                } catch (IOException | InterruptedException e) {

                    JOptionPane.showMessageDialog(null, "ERROR EN EL PUERTO DE CONEXION DE LA BALANZA");
                }
            }
        }
    }

}