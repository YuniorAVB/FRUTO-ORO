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

    public static void generateExcel(String tipo, String value, String fecha_desde, String fecha_hasta) throws Exception {
        try {
            PreparedStatement psmnt = null;

            long pesoBrutoTotal = 0;
            long pesoNetoTotal = 0;
            long pesoTaraTotal = 0;
            int cantidadPesajes = 0;

            try (Statement st = Conexion.getConexion().createStatement()) {

                String query = "Select * from "
                        + DataBase.TBL_PESAJE
                        + " AS pes INNER JOIN "
                        + DataBase.TBL_EMPLEADO
                        + " AS emp ON pes.pes_emp_id = emp.emp_id INNER JOIN "
                        + DataBase.TBL_CONDUCTOR
                        + " AS con ON con.con_id = pes.pes_con_id INNER JOIN "
                        + DataBase.TBL_MOVILIDAD
                        + " AS mov ON mov.mov_id = pes.pes_mov_id INNER JOIN "
                        + DataBase.TBL_EMPRESA_MOVILIDAD_DETALLE
                        + " AS epr_mov_det ON epr_mov_det.eprmovdet_mov_id = mov.mov_id INNER JOIN "
                        + DataBase.TBL_EMPRESA
                        + " AS epr ON epr.epr_id = epr_mov_det.eprmovdet_epr_id ";

                if (!value.isEmpty()) {
                    switch (tipo) {
                        case "CONDUCTOR":
                            query += " WHERE con.con_dni LIKE '%value%' ";
                            break;
                        case "EMPRESA":
                            query += " WHERE epr.epr_ruc LIKE '%value%' ";
                            break;
                        case "PRODUCTO":
                            query += " WHERE pes.pes_producto LIKE '%value%' ";
                            break;
                    }

                    query = query.replaceAll("value", value);
                }

                query += " AND pes.pes_fecha_ingreso BETWEEN '" + fecha_desde + "' AND '" + fecha_hasta + "' ";

                ResultSet rs = st.executeQuery(query);
                try (HSSFWorkbook wb = new HSSFWorkbook()) {
                    HSSFSheet sheet = wb.createSheet("Excel Sheet");
                    HSSFRow rowhead = sheet.createRow((short) 4);
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

                    int index = 7;
                    while (rs.next()) {
                        HSSFRow row = sheet.createRow((short) index);
                        row.createCell((short) 0).setCellValue(String.valueOf(rs.getDate("pes_fecha_ingreso")));
                        sheet.autoSizeColumn(0);
                        row.createCell((short) 1).setCellValue(String.valueOf(rs.getDate("pes_fecha_salida")));
                        sheet.autoSizeColumn(1);
                        row.createCell((short) 2).setCellValue(rs.getDouble("pes_peso_ingreso"));
                        sheet.autoSizeColumn(2);
                        row.createCell((short) 3).setCellValue(rs.getDouble("pes_peso_salida"));
                        sheet.autoSizeColumn(3);
                        row.createCell((short) 4).setCellValue(rs.getString("pes_hora_ingreso"));
                        sheet.autoSizeColumn(4);
                        row.createCell((short) 5).setCellValue(rs.getString("pes_hora_salida"));
                        sheet.autoSizeColumn(5);
                        row.createCell((short) 6).setCellValue(rs.getString("pes_tara"));
                        sheet.autoSizeColumn(6);
                        row.createCell((short) 7).setCellValue(rs.getString("pes_neto"));
                        sheet.autoSizeColumn(7);
                        row.createCell((short) 8).setCellValue(rs.getString("pes_bruto"));
                        sheet.autoSizeColumn(8);
                        row.createCell((short) 9).setCellValue(rs.getString("pes_producto"));
                        sheet.autoSizeColumn(9);
                        row.createCell((short) 10).setCellValue(rs.getString("con_nombre") + " - " + rs.getString("con_apellido"));
                        sheet.autoSizeColumn(10);
                        row.createCell((short) 11).setCellValue(rs.getString("con_dni"));
                        sheet.autoSizeColumn(11);
                        row.createCell((short) 12).setCellValue(rs.getString("mov_destino"));
                        sheet.autoSizeColumn(12);
                        row.createCell((short) 13).setCellValue(rs.getString("mov_procedencia"));
                        sheet.autoSizeColumn(13);
                        row.createCell((short) 14).setCellValue(rs.getString("epr_nombre"));
                        sheet.autoSizeColumn(14);
                        row.createCell((short) 15).setCellValue(rs.getString("epr_ruc"));
                        sheet.autoSizeColumn(15);
                        row.createCell((short) 16).setCellValue(rs.getString("emp_nombre"));
                        sheet.autoSizeColumn(16);
                        row.createCell((short) 17).setCellValue(rs.getString("emp_dni"));
                        sheet.autoSizeColumn(17);

                        cantidadPesajes++;
                        pesoBrutoTotal += convertLong(rs.getString("pes_bruto"));
                        pesoNetoTotal += convertLong(rs.getString("pes_neto"));
                        pesoTaraTotal += convertLong(rs.getString("pes_tara"));

                        index++;
                    }

                    HSSFRow rowSubHead1 = sheet.createRow((short) 0);
                    rowSubHead1.createCell((short) 0).setCellValue("FRUTO DE ORO");
                    sheet.autoSizeColumn(0);
                    rowSubHead1.createCell((short) 1).setCellValue("RESULTADOS PESAJES");
                    sheet.autoSizeColumn(1);
                    rowSubHead1.createCell((short) 2).setCellValue("TOTAL BRUTOS");
                    sheet.autoSizeColumn(2);
                    rowSubHead1.createCell((short) 3).setCellValue(pesoBrutoTotal);
                    sheet.autoSizeColumn(3);

                    HSSFRow rowSubHead2 = sheet.createRow((short) 1);
                    rowSubHead2.createCell((short) 2).setCellValue("TOTAL NETOS");
                    sheet.autoSizeColumn(2);
                    rowSubHead2.createCell((short) 3).setCellValue(pesoNetoTotal);
                    sheet.autoSizeColumn(3);

                    HSSFRow rowSubHead3 = sheet.createRow((short) 2);
                    rowSubHead3.createCell((short) 2).setCellValue("TOTAL TARA");
                    sheet.autoSizeColumn(2);
                    rowSubHead3.createCell((short) 3).setCellValue(pesoTaraTotal);
                    sheet.autoSizeColumn(3);

                    HSSFRow rowSubHead4 = sheet.createRow((short) 3);
                    rowSubHead4.createCell((short) 2).setCellValue("TOTAL PESAJES");
                    sheet.autoSizeColumn(2);
                    rowSubHead4.createCell((short) 3).setCellValue(cantidadPesajes);
                    sheet.autoSizeColumn(3);

                    ExportExcel.createFileExcel(wb, tipo);
                }
                JOptionPane.showMessageDialog(null, "EXCEL CREADO CORRECTAMENTE");

            }

        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, MensajeError.ERROR_LLAME_AL_PROGRAMADOR);
        }

    }

    public static long convertLong(String number) {

        double numero = Double.valueOf(number);
        return (new Double(numero)).longValue();
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
