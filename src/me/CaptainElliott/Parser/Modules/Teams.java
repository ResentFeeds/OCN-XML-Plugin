package me.CaptainElliott.Parser.Modules;

import java.util.HashMap;

/**
 * Created by Elliott on 21/09/2014.
 */
public class Teams {

    private static boolean teamsset = false;
    private static int NumberOfTeams;

    public static void setNumberOfTeams(int numberOfTeams) {
        NumberOfTeams = numberOfTeams;
    }

    public static int getNumberOfTeams() {
        return NumberOfTeams;
    }

    public static boolean isTeamsset() {
        return teamsset;
    }

    public static void setTeamsset(boolean teamsset) {
        Teams.teamsset = teamsset;
    }

    public static HashMap<Integer, String> name = new HashMap<Integer, String>();
    public static HashMap<Integer, String> max = new HashMap<Integer, String>();
    public static HashMap<Integer, String> maxoverfill = new HashMap<Integer, String>();
    public static HashMap<Integer, String> color = new HashMap<Integer, String>();

    public static void ResetHashMaps(){
        name.clear();
        max.clear();
        maxoverfill.clear();
        color.clear();
    }

    public static void ReplaceNameValue(Integer ID, String new_name){
        name.replace(ID, new_name);
    }

    public static void ReplaceMaxValue(Integer ID, String new_max){
        max.replace(ID, new_max);

    }

    public static void ReplaceMaxOverfillValue(Integer ID, String new_max){
        maxoverfill.replace(ID, new_max);
    }

    public static void ReplaceColorValue(Integer ID, String new_color){
        color.replace(ID, new_color);
    }


}
