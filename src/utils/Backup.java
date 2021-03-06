/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import config.DataBase;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class Backup {

    public static void generarBackup(String nombre) {

        String nameBackup = nombre + "-"
                + LocalDateTime.now().toString() + ".sql";

        Thread thread = new Thread(() -> {
            try {
                Process p = Runtime
                        .getRuntime()
                        .exec(DataBase.DB_BACKUP_GENERATE);

                InputStream is = p.getInputStream();
                try (FileOutputStream fos = new FileOutputStream(nameBackup)) {
                    byte[] buffer = new byte[1000];

                    int leido = is.read(buffer);
                    while (leido > 0) {
                        fos.write(buffer, 0, leido);
                        leido = is.read(buffer);
                    }
                }

                JOptionPane.showMessageDialog(null, "BACKUP REALIZADO CON EXITO");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        thread.start();
    }

    public static void restaurarBackup(String fileBackup) {

        String[] files = {" source " + fileBackup};

        String[] executeCmd = Stream.of(DataBase.DB_BACKUP_RESTORE, files).flatMap(Stream::of).toArray(String[]::new);

            System.out.println(Arrays.toString(executeCmd));
        
        Thread thread = new Thread(() -> {
            try {
                //  Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);

                Process runtimeProcess = Runtime
                        .getRuntime()
                        .exec(DataBase.DB_BACKUP_RESTORE_STRING + " source " + fileBackup);
                int processComplete = runtimeProcess.waitFor();

                if (processComplete == 0) {
                    JOptionPane.showMessageDialog(null, "Restauracion del backup con Exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la Restauracion");
                }
            } catch (HeadlessException | IOException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        thread.start();

    }

}
