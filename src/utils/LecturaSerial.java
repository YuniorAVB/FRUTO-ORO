/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
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

            if (portId.getName().equalsIgnoreCase("COM1")) {
                try {
                    serialport = (SerialPort) portId.open("LecturaSerial", 1000);
                    entrada = serialport.getInputStream();

                    t.start();

                } catch (PortInUseException | IOException e) {
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

                    String[] pesos = st.split("B");
                    String[] pesos2 = st.split("+");

                    if (pesos.length > 2) {

                        String pesoParseado = "0KG";
                        if (pesos[1].length() - 1 >= 10) {

                            pesoParseado = pesos[1].substring(3, pesos[1].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos[2].length() - 1 >= 10) {
                            pesoParseado = pesos[2].substring(3, pesos[2].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos[3].length() - 1 >= 10) {
                            pesoParseado = pesos[3].substring(3, pesos[3].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos[4].length() - 1 >= 10) {
                            pesoParseado = pesos[4].substring(3, pesos[4].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        }

                    } else if (pesos2.length > 2) {
                        String pesoParseado = "0KG";
                        if (pesos2[1].length() - 1 >= 10) {

                            pesoParseado = pesos2[1].substring(3, pesos2[1].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos2[2].length() - 1 >= 10) {
                            pesoParseado = pesos2[2].substring(3, pesos2[2].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos2[3].length() - 1 >= 10) {
                            pesoParseado = pesos2[3].substring(3, pesos2[3].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

                        } else if (pesos2[4].length() - 1 >= 10) {
                            pesoParseado = pesos2[4].substring(3, pesos2[4].length() - 2);

                            labelClasePeso.setText(String.valueOf(Math.abs(Integer.parseInt(pesoParseado))) + "KG");

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
