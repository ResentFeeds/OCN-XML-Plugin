package me.CaptainElliott.Parser;

import me.CaptainElliott.Parser.Modules.Name;
import me.CaptainElliott.XMLPlugin;

import java.io.File;

/**
 * Created by Elliott on 20/09/2014.
 */
public class Parser {

    private static File datafolder = XMLPlugin.plugin.getDataFolder();
    private static File xmldoc = new File(datafolder, Name.getName() + ".txt");



    public static File getDatafolder() {
        return datafolder;
    }

    public static File getXmldoc() {
        return xmldoc;
    }




}




