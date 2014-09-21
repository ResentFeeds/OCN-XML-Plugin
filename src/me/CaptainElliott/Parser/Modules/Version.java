package me.CaptainElliott.Parser.Modules;

import org.jdom2.Element;

/**
 * Created by Elliott on 21/09/2014.
 */
public class Version {

    private static boolean versionset = false;
    private static String version;
    public static Element ElVersion = new Element("version");

    public static void setVersion(String version) {
        Version.version = version;
    }

    public static String getVersion() {
        return version;
    }

    public static boolean isVersionset() {
        return versionset;
    }

    public static void setVersionset(boolean versionset) {
        Version.versionset = versionset;
    }
}
