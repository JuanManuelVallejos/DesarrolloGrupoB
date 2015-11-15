package ar.edu.unq.desapp.grupoB022015.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CVSParser {

  /*public static void main(String[] args) throws Throwable {

	System.out.println(CVSParser.readCVS("/Users/musimundo/Downloads/newDate.csv"));
	System.out.println(CVSParser.readCVSForPlayers("/Users/musimundo/Downloads/players.cvs"));
  }*/

  public static void refresh(SuperGol system, String path) throws Throwable{
	  HashMap<Integer,Integer> idPlayer_AmountGoals = readCVS(path);
	  for(Integer idPlayer :idPlayer_AmountGoals.keySet()){
		   system.playerScoredNGoals(idPlayer, idPlayer_AmountGoals.get(idPlayer));
	  }
  }
  
  @SuppressWarnings("resource")
  public static HashMap<Integer,Integer> readCVS(String path) throws Throwable {

	String csvFile = path;
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	
	HashMap<Integer,Integer> idPlayer_AmountGoals = new HashMap<Integer,Integer>();


	br = new BufferedReader(new FileReader(csvFile));
	line = br.readLine();
	while ((line = br.readLine()) != null) {

	    // use comma as separator
		String[] row = line.split(cvsSplitBy);
		
		idPlayer_AmountGoals.put(Integer.parseInt(row[0]),Integer.parseInt(row[2]));
	
	}
	return idPlayer_AmountGoals;

  }
  @SuppressWarnings("resource")
  public static List<List<String>> readCVSForPlayers(String path) throws Throwable {

	String csvFile = path;
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	
	List<List<String>> datesForPlayers = new ArrayList<List<String>>();

	br = new BufferedReader(new FileReader(csvFile));
	line = br.readLine();
	while ((line = br.readLine()) != null) {

	    // use comma as separator
		String[] row = line.split(cvsSplitBy);
		
		List<String> player = new ArrayList<String>();
		player.add(row[0]);
		player.add(row[1]);
		player.add(row[2]);
		datesForPlayers.add(player);
	
	}
	return datesForPlayers;

  }
}