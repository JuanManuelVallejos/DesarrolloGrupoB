package ar.edu.unq.desapp.grupoB022015.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.modelo.builders.EquipoBuilder;
import ar.edu.unq.desapp.grupoB022015.modelo.builders.JugadorBuilder;
import ar.edu.unq.desapp.grupoB022015.modelo.exceptions.NoSePuedeHaberMasDeOnceJugadoresException;
import junit.framework.TestCase;

public class TestEquipo extends TestCase{

	public List<Jugador> crearPlantel(){
		Arquero arq = JugadorBuilder.algunArquero().build();
		
		Defensor def1 = JugadorBuilder.algunDefensor().build();
		Defensor def2 = JugadorBuilder.algunDefensor().build();
		Defensor def3 = JugadorBuilder.algunDefensor().build();
		
		Mediocampista med1 = JugadorBuilder.algunMediocampista().build();
		Mediocampista med2 = JugadorBuilder.algunMediocampista().build();
		Mediocampista med3 = JugadorBuilder.algunMediocampista().build();
		Mediocampista med4 = JugadorBuilder.algunMediocampista().build();
		
		Atacante atc1 = JugadorBuilder.algunAtacante().build();
		Atacante atc2 = JugadorBuilder.algunAtacante().build();
		Atacante atc3 = JugadorBuilder.algunAtacante().build();
		
		List<Jugador> plantel = new ArrayList<Jugador>();
		plantel.add(arq);
		
		plantel.add(def1);
		plantel.add(def2);
		plantel.add(def3);
		
		plantel.add(med1);
		plantel.add(med2);
		plantel.add(med3);
		plantel.add(med4);
		
		plantel.add(atc1);
		plantel.add(atc2);
		plantel.add(atc3);
		
		return plantel;
	}
	
	public void agregarPlantelInicial(Equipo equipo){
		for(Jugador j: crearPlantel()){
			try {
				equipo.agregarJugador(j);
			} catch (NoSePuedeHaberMasDeOnceJugadoresException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test_todosLosJugadores_retornaATodosLosJugadoresDelEquipo(){
		Equipo equipo = EquipoBuilder.algunEquipo().build();
		agregarPlantelInicial(equipo);
		
		assertEquals(equipo.todosLosJugadores().size(), 11);
	}
	
	@Test(expected = NoSePuedeHaberMasDeOnceJugadoresException.class) 
	public void test_agregarMasDe11Jugadores_throwNoSePuedeHaberMasDeOnceJugadoresException(){
		Equipo equipo = EquipoBuilder.algunEquipo().build();
		agregarPlantelInicial(equipo);
		
		try{
			equipo.agregarJugador(JugadorBuilder.algunJugador().build()); // en esta operacion tira la excepcion
			fail();
		}catch(NoSePuedeHaberMasDeOnceJugadoresException e){
			assertTrue(true);
		}
	}
}
