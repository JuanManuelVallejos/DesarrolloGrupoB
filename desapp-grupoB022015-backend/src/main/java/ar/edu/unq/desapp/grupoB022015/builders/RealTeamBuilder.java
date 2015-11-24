package ar.edu.unq.desapp.grupoB022015.builders;

import ar.edu.unq.desapp.grupoB022015.model.RealTeam;

public class RealTeamBuilder  extends AbstractBuilder<RealTeam> {

    @Override
    public RealTeam anyObject() {
        return new RealTeam("");
    }
    
}
