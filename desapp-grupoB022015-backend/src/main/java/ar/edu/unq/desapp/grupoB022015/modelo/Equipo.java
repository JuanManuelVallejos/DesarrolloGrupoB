package ar.edu.unq.desapp.grupoB022015.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoPuedeHaberMasDeUnArqueroException;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeHaberMasDeOnceJugadoresException;

public class Equipo {

	private List<Jugador> plantel;
	
	
	
	//------------------ Interfaz publica ------------------\\
	
	public Equipo(){
		plantel = new ArrayList<Jugador>();
	}
	
	public void agregarJugador(Jugador unJugador) throws NoSePuedeHaberMasDeOnceJugadoresException,
														 NoPuedeHaberMasDeUnArqueroException{
	}

	public List<Jugador> todosLosJugadores() {
		return plantel;
	}

}
