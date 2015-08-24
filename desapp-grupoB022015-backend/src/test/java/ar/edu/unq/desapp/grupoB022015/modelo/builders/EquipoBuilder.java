package ar.edu.unq.desapp.grupoB022015.modelo.builders;

import ar.edu.unq.desapp.grupoB022015.modelo.Equipo;

public class EquipoBuilder {
	private Equipo equipo;
	
	private EquipoBuilder(Equipo unEquipo){
		equipo = unEquipo;
	}
	
	public static EquipoBuilder algunEquipo(){
		Equipo equipo = new Equipo();
		EquipoBuilder instance = new EquipoBuilder(equipo);
		return instance;
	}
	
	public Equipo build(){
		return equipo;
	}
}
