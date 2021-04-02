package utils;

/**
 *
 * @author YAVB
 */
public class ValidateDNI {

    public static boolean validarDni(String dni) {

        if (dni.matches("\\d+") == true) {
         
            return dni.length() == 8;
        }
        return false;

    }

}
