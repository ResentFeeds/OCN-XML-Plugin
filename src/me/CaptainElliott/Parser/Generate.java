package me.CaptainElliott.Parser;

import me.CaptainElliott.Parser.Modules.Name;
import me.CaptainElliott.Parser.Modules.Objective;
import me.CaptainElliott.Parser.Modules.Teams;
import me.CaptainElliott.Parser.Modules.Version;
import org.bukkit.Bukkit;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Elliott on 21/09/2014.
 */
public class Generate extends Parser{

    private static Element root = new Element("map");
    private static Document doc = new Document();

    public static void GenerateFile(){
        if(!getDatafolder().exists()){
           getDatafolder().mkdir();
        } else {
            try {
                doc.setRootElement(root);
                root.setAttribute("proto", "1.3.5");

                Name.ElName.addContent(new Text(Name.getName()));
                root.addContent(Name.ElName);

                if(Version.isVersionset()){
                    Version.ElVersion.addContent(new Text(Version.getVersion()));
                    root.addContent(Version.ElVersion);
                }
                if(Objective.isObjectiveset()){
                    Objective.ElObjective.addContent(new Text(Objective.getObjective()));
                    root.addContent(Objective.ElObjective);
                }
                if(Teams.isTeamsset()){
                    Element teams = new Element("teams");
                    root.addContent(teams);
                    for(int i = 0;Teams.getNumberOfTeams() > i; i++){
                        Bukkit.broadcastMessage("Does it get here?");
                        Element team = new Element("team");
                        String name = Teams.name.get(i+1);
                        team.addContent(Teams.name.get(i+1));
                        team.setAttribute("color", Teams.color.get(name));
                        team.setAttribute("max", Teams.max.get(name));
                        team.setAttribute("max-ovefill", Teams.maxoverfill.get(name));
                        teams.addContent(team);
                    }
                }

                Parser.getXmldoc().createNewFile();

                XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());

                xmlOutput.output(doc, new FileOutputStream(getXmldoc()));
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
