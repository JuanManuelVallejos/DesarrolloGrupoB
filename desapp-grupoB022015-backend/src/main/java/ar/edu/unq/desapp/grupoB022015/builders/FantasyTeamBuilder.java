package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.FantasyTeam;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class FantasyTeamBuilder extends AbstractBuilder<FantasyTeam> {

    @Override
    public FantasyTeam anyObject() {
        return new FantasyTeam(new User(0,new SuperGol()),"");
    }

}
