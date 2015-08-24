package ar.edu.unq.desapp.grupoB022015.modelo.builders;

import ar.edu.unq.desapp.grupoB022015.modelo.Arquero;
import ar.edu.unq.desapp.grupoB022015.modelo.Atacante;
import ar.edu.unq.desapp.grupoB022015.modelo.Defensor;
import ar.edu.unq.desapp.grupoB022015.modelo.Jugador;
import ar.edu.unq.desapp.grupoB022015.modelo.Mediocampista;

public class JugadorBuilder <T extends Jugador>{

	private T jugador;
	
	private JugadorBuilder(){
	}
	
	public static <R extends Jugador> JugadorBuilder<R> algunJugador(){
		return new JugadorBuilder<R>();
	}
	
	@SuppressWarnings("unchecked")
	private static <R extends Jugador> JugadorBuilder<R> crearInstancia(String nombreDeLaClase){
		JugadorBuilder<R> instance = JugadorBuilder.<R>algunJugador();
		
		try {
			instance.jugador = (R) Class.forName(nombreDeLaClase).newInstance();
		}catch(Exception e){
		}
		return instance;
	}
	
	public static JugadorBuilder<Arquero> algunArquero(){
		return JugadorBuilder.<Arquero>crearInstancia("Arquero");
	}
	
	public static JugadorBuilder<Defensor> algunDefensor(){
		return JugadorBuilder.<Defensor>crearInstancia("Defensor");
	}
	
	public static JugadorBuilder<Mediocampista> algunMediocampista(){
		return JugadorBuilder.<Mediocampista>crearInstancia("Mediocampista");
	}
	
	public static JugadorBuilder<Atacante> algunAtacante(){
		return JugadorBuilder.<Atacante>crearInstancia("Atacante");
	}
	
	
	public T build(){
		return (T) jugador;
	}
	
}
