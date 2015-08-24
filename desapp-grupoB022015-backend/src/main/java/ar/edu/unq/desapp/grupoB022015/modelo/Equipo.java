package ar.edu.unq.desapp.grupoB022015.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeHaberMasDeOnceJugadoresException;

public class Equipo {

	private List<Jugador> plantel = new ArrayList<Jugador>();
	
	private boolean hayOnceJugadores() {
		return plantel.size() == 11;
	}
	
	public void agregarJugador(Jugador unJugador) throws NoSePuedeHaberMasDeOnceJugadoresException{
		if(hayOnceJugadores())
			throw new NoSePuedeHaberMasDeOnceJugadoresException();
		plantel.add(unJugador);
	}

	public List<Jugador> todosLosJugadores() {
		return plantel;
	}

}
