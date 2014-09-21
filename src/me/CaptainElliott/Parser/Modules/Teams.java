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
    public static HashMap<String, String> max = new HashMap<String, String>();
    public static HashMap<String, String> maxoverfill = new HashMap<String, String>();
    public static HashMap<String, String> color = new HashMap<String, String>();

    public static void ResetHashMaps(){
        name.clear();
        max.clear();
        maxoverfill.clear();
        color.clear();
    }



}
