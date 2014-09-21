package me.CaptainElliott.Utils;

/**
 * Created by Elliott on 21/09/2014.
 */
public class StringUtils {

    public static boolean isAlphaNumeric(String s){
        String pattern = "^[a-zA-Z0-9]*$";
        if(s.matches(pattern)){
            return true;
        }
        return false;
    }
}
