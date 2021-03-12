
package utils;

import config.DataBase;
import config.Rutas;
import db.Conexion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {

    public static void generateExcel(String tabla) throws Exception {

        try {

            PreparedStatement psmnt = null;
            Statement st = Conexion.getConexion().createStatement();
            try (ResultSet rs = st.executeQuery("Select * from " + tabla)) {
                HSSFWorkbook wb = new HSSFWorkbook();
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
                    index++;
                }
                FileOutputStream fileOut = new FileOutputStream(Rutas.DIR_HOME + "\\home.xlsx");
                wb.write(fileOut);

            }

        } catch (IOException | SQLException e) {
        }

    }

    public static void main(String[] args) throws Exception {

        ExportExcel.generateExcel(DataBase.TBL_PESAJE);

    }
}
