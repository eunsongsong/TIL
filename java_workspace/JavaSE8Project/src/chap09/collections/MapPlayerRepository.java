package chap09.collections;

import java.util.*;

public class MapPlayerRepository {
  HashMap<String, String> players;

  public MapPlayerRepository() {
    players = new HashMap<String, String> ();
  }

  public String get(String position) {
    String player = players.get(position);
    return player;
  }

  public void put(String position, String name) {    
    players.put(position, name);
  }
  
  public static void main(String[] args){
    MapPlayerRepository dreamteam = new MapPlayerRepository();
    
    dreamteam.put("forward", "henry");
    dreamteam.put("rightwing", "ronaldo");
    dreamteam.put("goalkeeper", "cech");
    
    System.out.println("Forward is " + dreamteam.get("forward"));
    System.out.println("Right wing is " + dreamteam.get("rightwing"));
    System.out.println("Goalkeeper is " + dreamteam.get("goalkeeper"));    
  }
}