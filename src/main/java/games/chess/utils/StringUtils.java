package games.chess.utils;

public class StringUtils {
    public static boolean isInteger(String value){
        try {
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
