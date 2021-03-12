/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author user
 */
public class LeerPuertoSerial implements Runnable {

    public static void getPorts() {

        SerialPort serialport;

        try {
            CommPortIdentifier port;

            Enumeration<?> puerto = CommPortIdentifier.getPortIdentifiers();

            while (puerto.hasMoreElements()) {
                port = (CommPortIdentifier) puerto.nextElement();

                System.out.println(port.getName());

                if (port.getName().equals("COM9")) {

                    serialport = (SerialPort) port.open("PuertoSerial", 500);
                    InputStream entrada = serialport.getInputStream();

                    System.out.println(entrada.read());

                }
            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        LeerPuertoSerial.getPorts();
    }

    @Override
    public void run() {
        getPorts(); //To change body of generated methods, choose Tools | Templates.
    }

}
