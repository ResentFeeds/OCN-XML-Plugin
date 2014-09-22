package me.CaptainElliott.Commands.Modules;

import me.CaptainElliott.Parser.Modules.Objective;
import me.CaptainElliott.Parser.Modules.Teams;
import me.CaptainElliott.Parser.Modules.Version;

/**
 * Created by Elliott on 22/09/2014.
 */
public class ModuleUtils {

    public static void ResetModules(){
        me.CaptainElliott.Parser.Modules.Name.setName(null);
        me.CaptainElliott.Parser.Modules.Name.setNameset(false);

        me.CaptainElliott.Parser.Modules.Version.setVersion(null);
        Version.setVersionset(false);

        me.CaptainElliott.Parser.Modules.Objective.setObjective(null);
        Objective.setObjectiveset(false);

        me.CaptainElliott.Parser.Modules.Teams.setNumberOfTeams(0);
        me.CaptainElliott.Parser.Modules.Teams.ResetHashMaps();
        Teams.setTeamsset(false);
        me.CaptainElliott.Commands.Modules.Teams.setTeamCalledTimes(0);
    }

}
