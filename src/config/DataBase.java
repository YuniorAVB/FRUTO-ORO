package config;

public class DataBase {

    final static public String DB_NAME = "fruto_oro";
    final static public String DB_USER = "root";
    final static public String DB_PASSWORD = "castrofcb";
    final static public String DB_PORT = "3306";
    final static public String DB_HOST = "localhost";

    final static public String DB_RUTA_INSTALL_GENERATE = "C:\\xampp\\mysql\\bin\\mysqldump ";

    final static public String DB_RUTA_INSTALL_RESTORE = "C:\\xampp\\mysql\\bin\\mysql ";

    final static public String DB_BACKUP_GENERATE = DB_RUTA_INSTALL_GENERATE + " -u " + DB_USER + " -p" + DB_PASSWORD + " " + DB_NAME;

    final static public String[] DB_BACKUP_RESTORE = {DB_RUTA_INSTALL_RESTORE, DB_NAME, "-u" + DB_USER, "-p" + DB_PASSWORD, "-e"};

    final static public String DB_BACKUP_RESTORE_STRING = DB_RUTA_INSTALL_RESTORE + DB_NAME + " -u " + DB_USER + " -p" + DB_PASSWORD + " -e ";

    final static public String TBL_SESSION = "app_session";
    final static public String TBL_MODELO_TICKET = "app_modelo_ticket";
    final static public String TBL_EMPLEADO = "app_empleado";
    final static public String TBL_CONDUCTOR = "app_conductor";
    final static public String TBL_EMPRESA = "app_empresa";
    final static public String TBL_MOVILIDAD = "app_movilidad";
    final static public String TBL_EMPRESA_MOVILIDAD_DETALLE = "app_empresa_movilidad_detalle";
    final static public String TBL_EMPRESA_CONDUCTOR_DETALLE = "app_empresa_conductor_detalle";
    final static public String TBL_PESAJE = "app_pesaje";
    final static public String TBL_PESAJE_TICKET = "app_pesaje_ticket";

}
