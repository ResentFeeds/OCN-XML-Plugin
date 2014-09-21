package me.CaptainElliott.Parser.Modules;

import org.jdom2.Element;

/**
 * Created by Elliott on 21/09/2014.
 */
public class Name {

    private static boolean nameset = false;
    private static String name;
    public static Element ElName = new Element("name");

    public static void setName(String name) {
        Name.name = name;
    }

    public static String getName() {
        return name;
    }

    public static boolean isNameset() {
        return nameset;
    }

    public static void setNameset(boolean nameset) {
        Name.nameset = nameset;
    }
}
