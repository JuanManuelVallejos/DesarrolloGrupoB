package ar.edu.unq.desapp.grupoB022015.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Forward;
import ar.edu.unq.desapp.grupoB022015.model.Goalkeeper;
import ar.edu.unq.desapp.grupoB022015.model.Midfielder;
import ar.edu.unq.desapp.grupoB022015.model.Player;

public class PlayerTest {

	private Player player;

	@Before
    public void init() {
      player = new Player();
    }
	
	@Test
	public void testPointsForNGoalOfDefender() {
		player.setPosition(new Defender());
		assertEquals(player.getPointForNGoals(1), 3);
		assertEquals(player.getPointForNGoals(10), 30);
	}

	@Test
	public void testPointsForNGoalOfGoalKeeper() {
		player.setPosition(new Goalkeeper());
		assertEquals(player.getPointForNGoals(0), 2);
		assertEquals(player.getPointForNGoals(1), 0);
	}
	
	@Test
	public void testPointsForNGoalOfMidfielder() {
		player.setPosition(new Midfielder());
		assertEquals(player.getPointForNGoals(1),  1);
		assertEquals(player.getPointForNGoals(10), 10);
	}
	
	@Test
	public void testPointsForNGoalOfForward() {
		player.setPosition(new Forward());
		assertEquals(player.getPointForNGoals(1),  1);
		assertEquals(player.getPointForNGoals(10), 10);
	}
	
	
}
