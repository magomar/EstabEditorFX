package net.deludobellico.estabeditorfx.deprecated;

/**
 * Created by Mario on 04/08/2014.
 */
@Deprecated
class Util {
    /**
     * Check if provided string is an Integer
     *
     * @param s the string to check
     * @return whether {@code} s is an Integer or not
     */
    public static boolean isInteger(String s) {
        try {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
