package me.CaptainElliott.Parser.Modules;

import org.jdom2.Element;

/**
 * Created by Elliott on 21/09/2014.
 */
public class Objective {

    private static boolean objectiveset = false;
    private static String objective;
    public static Element ElObjective = new Element("objective");

    public static void setObjective(String objective) {
        Objective.objective = objective;
    }

    public static String getObjective() {
        return objective;
    }

    public static boolean isObjectiveset() {
        return objectiveset;
    }

    public static void setObjectiveset(boolean objectiveset) {
        Objective.objectiveset = objectiveset;
    }

}
