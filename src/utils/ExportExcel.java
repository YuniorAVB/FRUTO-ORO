package utils;

import config.DataBase;
import config.MensajeError;
import config.Rutas;
import db.Conexion;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {

    public static void generateExcel(String tipo, String value) throws Exception {
        try {
            PreparedStatement psmnt = null;

            try (Statement st = Conexion.getConexion().createStatement()) {

                String query = "Select * from "
                        + DataBase.TBL_PESAJE
                        + " AS pes INNER JOIN "
                        + DataBase.TBL_EMPLEADO
                        + " AS emp ON pes.pes_emp_id = emp_id INNER JOIN "
                        + DataBase.TBL_CONDUCTOR
                        + " AS con ON con_id = pes_con_id INNER JOIN "
                        + DataBase.TBL_MOVILIDAD
                        + " AS mov ON mov_id = pes_mov_id INNER JOIN "
                        + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE
                        + " AS epr_mov_det ON epr_mov_det.eprmovdet_mov_id = mov_id INNER JOIN "
                        + DataBase.TBL_EMPRESA
                        + " AS epr ON epr.epr_id = epr_mov_det.eprmovdet_epr_id "
                        + " WHERE ";

                switch (tipo) {
                    case "CONDUCTOR":
                        query += " con_dni = " + value;
                }

                ResultSet rs = st.executeQuery(query);
                try (HSSFWorkbook wb = new HSSFWorkbook()) {
                    HSSFSheet sheet = wb.createSheet("Excel Sheet");
                    HSSFRow rowhead = sheet.createRow((short) 0);
                    rowhead.createCell((short) 0).setCellValue("FECHA INGRESO");
                    sheet.autoSizeColumn(0);
                    rowhead.createCell((short) 1).setCellValue("FECHA SALIDA");
                    sheet.autoSizeColumn(1);
                    rowhead.createCell((short) 2).setCellValue("PESO INGRESO");
                    sheet.autoSizeColumn(2);
                    rowhead.createCell((short) 3).setCellValue("PESO SALIDA");
                    sheet.autoSizeColumn(3);
                    rowhead.createCell((short) 4).setCellValue("HORA INGRESO");
                    sheet.autoSizeColumn(4);
                    rowhead.createCell((short) 5).setCellValue("HORA SALIDA");
                    sheet.autoSizeColumn(5);
                    rowhead.createCell((short) 6).setCellValue("PESO TARA");
                    sheet.autoSizeColumn(6);
                    rowhead.createCell((short) 7).setCellValue("PESO NETO");
                    sheet.autoSizeColumn(7);
                    rowhead.createCell((short) 8).setCellValue("PESO BRUTO");
                    sheet.autoSizeColumn(8);
                    rowhead.createCell((short) 9).setCellValue("PRODUCTO");
                    sheet.autoSizeColumn(9);
                    rowhead.createCell((short) 10).setCellValue("CONDUCTOR");
                    sheet.autoSizeColumn(10);
                    rowhead.createCell((short) 11).setCellValue("CONDUCTOR DNI");
                    sheet.autoSizeColumn(11);
                    rowhead.createCell((short) 12).setCellValue("DESTINO");
                    sheet.autoSizeColumn(12);
                    rowhead.createCell((short) 13).setCellValue("PROCEDENCIA");
                    sheet.autoSizeColumn(13);
                    rowhead.createCell((short) 14).setCellValue("EMPRESA");
                    sheet.autoSizeColumn(14);
                    rowhead.createCell((short) 15).setCellValue("RUC-EMPRESA");
                    sheet.autoSizeColumn(15);
                    rowhead.createCell((short) 16).setCellValue("EMPLEADO");
                    sheet.autoSizeColumn(16);
                    rowhead.createCell((short) 17).setCellValue("EMPLEADO DNI");
                    sheet.autoSizeColumn(17);

                    int index = 1;
                    while (rs.next()) {
                        HSSFRow row = sheet.createRow((short) index);
                        row.createCell((short) 0).setCellValue(String.valueOf(rs.getDate("pes_fecha_ingreso")));
                        row.createCell((short) 1).setCellValue(String.valueOf(rs.getDate("pes_fecha_salida")));
                        row.createCell((short) 2).setCellValue(rs.getDouble("pes_peso_ingreso"));
                        row.createCell((short) 3).setCellValue(rs.getDouble("pes_peso_salida"));
                        row.createCell((short) 4).setCellValue(rs.getString("pes_hora_ingreso"));
                        row.createCell((short) 5).setCellValue(rs.getString("pes_hora_salida"));
                        row.createCell((short) 6).setCellValue(rs.getString("pes_tara"));
                        row.createCell((short) 7).setCellValue(rs.getString("pes_neto"));
                        row.createCell((short) 8).setCellValue(rs.getString("pes_bruto"));
                        row.createCell((short) 9).setCellValue(rs.getString("pes_producto"));
                        row.createCell((short) 10).setCellValue(rs.getString("con_nombre") + " - " + rs.getString("con_apellido"));
                        row.createCell((short) 11).setCellValue(rs.getString("con_dni"));
                        row.createCell((short) 12).setCellValue(rs.getString("mov_destino"));
                        row.createCell((short) 13).setCellValue(rs.getString("mov_procedencia"));
                        row.createCell((short) 14).setCellValue(rs.getString("epr_nombre"));
                        row.createCell((short) 15).setCellValue(rs.getString("epr_ruc"));
                        row.createCell((short) 16).setCellValue(rs.getString("emp_nombre"));
                        row.createCell((short) 17).setCellValue(rs.getString("emp_dni"));
                        index++;
                    }
                    ExportExcel.createFileExcel(wb, "REPORTE GENERAL");
                }
                JOptionPane.showMessageDialog(null, "EXCEL CREADO CORRECTAMENTE");

            }

        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
            System.out.println(e.getMessage());
        }

    }

    public static void createFileExcel(HSSFWorkbook excel, String nombre) {
        String dateNow = LocalDate.now().toString();
        try (FileOutputStream fileOut = new FileOutputStream(Rutas.DIR_HOME + "\\Excel" + dateNow + "-" + nombre + ".xlsx")) {
            try {
                excel.write(fileOut);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }
    }

}
