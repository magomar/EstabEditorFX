package net.deludobellico.commandops.estabeditor.util;

/**
 * Created by Mario on 04/08/2014.
 */
public class Util {
    /**
     * Check if provided string is an Integer
     *
     * @param s the string to check
     * @return whether {@code} s is an Integer or not
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
