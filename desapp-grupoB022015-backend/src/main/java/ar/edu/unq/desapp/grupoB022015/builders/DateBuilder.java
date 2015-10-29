package ar.edu.unq.desapp.grupoB022015.builders;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import ar.edu.unq.desapp.grupoB022015.model.Date;
import ar.edu.unq.desapp.grupoB022015.model.Match;

public class DateBuilder extends AbstractBuilder<Date> {

	@Override
	public Date anyObject() {
		List<Match> matches = new ArrayList<Match>();
		DateTime dt = new DateTime();
		return new Date(matches,dt,dt);
	}

}
