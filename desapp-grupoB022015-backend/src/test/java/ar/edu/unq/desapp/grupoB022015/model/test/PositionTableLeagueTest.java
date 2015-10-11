package ar.edu.unq.desapp.grupoB022015.model.test;

import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.junit.Test;
import ar.edu.unq.desapp.grupoB022015.model.Defender;
import ar.edu.unq.desapp.grupoB022015.model.Forward;
import ar.edu.unq.desapp.grupoB022015.model.League;
import ar.edu.unq.desapp.grupoB022015.model.Midfielder;
import ar.edu.unq.desapp.grupoB022015.model.Player;
import ar.edu.unq.desapp.grupoB022015.model.SuperGol;
import ar.edu.unq.desapp.grupoB022015.model.User;

public class PositionTableLeagueTest {

	private SuperGol superGol;
	
	private League league;
	
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	
	private Player player6;
	private Player player5;
	private Player player4;
	private Player player3;
	private Player player2;
	private Player player1;
	

	@Test
	public void testForTableLeague() {
      superGol = new SuperGol();
      
      user1 = new User(1, superGol);
      user2 = new User(2, superGol);
      user3 = new User(3, superGol);
      user4 = new User(4, superGol);

      user1.createTeam("User1 Team");
      user2.createTeam("User2 Team");
      user3.createTeam("User3 Team");
      user4.createTeam("User4 Team");
      
      league = user1.createLeague("The League");
      
      user2.addmeToLeague(league);
      user3.addmeToLeague(league);
      user4.addmeToLeague(league);
      
      league.createFixtureRoundTrip(new DateTime(), 7);
      
      player1 = new Player(superGol, 1, "Jon", new Defender());
      player2 = new Player(superGol, 2, "Smith", new Defender());
      player3 = new Player(superGol, 3, "Steve", new Defender());
      player4 = new Player(superGol, 4, "Peter", new Midfielder());
      player5 = new Player(superGol, 5, "Louis", new Forward());
      player6 = new Player(superGol, 6, "Jimbo", new Forward());
      
      user1.addPlayersToMyTeam(player1,player2);
      user2.addPlayersToMyTeam(player5,player6);
      user3.addPlayersToMyTeam(player5,player6);
      user4.addPlayersToMyTeam(player3,player4);
      
      
		superGol.playerScoredNGoals(player1,1);
		superGol.playerScoredNGoals(player2,1);
		
		superGol.playerScoredNGoals(player3,1);
		superGol.playerScoredNGoals(player4,2);
		
		superGol.playerScoredNGoals(player5,1);
		superGol.playerScoredNGoals(player6,1);
		
		//player1: 3  <- u1
		//player2: 3  <- u1
		//player3: 3  <- u4
		//player4: 2  <- u4
		//player5: 1  <- u3, u2
		//player6: 1  <- u3, u2
		
		league.refreshTablePoints();
		league.updateGeneralRAnking();
		
		league.createFixtureOnlyTrip(new DateTime(), 1);
				
		// Date 1 =
		//user1 vs user4
		//user2 vs user3
		
		assertEquals(league.getTablePointsForUser(user1),3);
		assertEquals(league.getTablePointsForUser(user2),1);
		assertEquals(league.getTablePointsForUser(user3),1);
		assertEquals(league.getTablePointsForUser(user4),0);
		
	}

}
