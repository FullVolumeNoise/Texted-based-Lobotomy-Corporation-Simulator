import java.lang.*;
import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class lobotomy_corp{
  /**
  * Ctrl + Shift + B to run
  * Abnormalitiy class: name, quote, rank
  */

  public static int LOB;

  private static ArrayList<Agent> workers = new ArrayList<Agent>();
// ArrayList<String> cars = new ArrayList<String>();
  private static int day = 0;
  public static int energyTotal;
  public static int energyNeeded;
  private static Hashtable<Integer, Abnormal> abnormDict = new Hashtable<Integer, Abnormal>();
  private static Hashtable<String, Agent> agentDict = new Hashtable<String, Agent>();
  private static ArrayList<Integer> IDNums = new ArrayList<Integer>();
  private static ArrayList<Abnormal> Monsters = new ArrayList<Abnormal>();

  private static ArrayList<Abnormal> inFacility = new ArrayList<Abnormal>();



  public static Agent HireAgents(){
    Agent beck = new Agent();
    System.out.println("Hired: " + beck.name);
    lobotomy_corp.workers.add(beck);
    agentDict.put(beck.name, beck);
    LOB -= 1;
    return beck;
  }

  public static ArrayList<Abnormal> parseAbnormalities(){

    try{
      String basic = "";
      File myObj = new File("abnormalities.json");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        basic += myReader.nextLine();
        //  System.out.println(data);
      }

      myReader.close();
      System.out.println(basic);

      Object obj = JSONValue.parse(basic);
      JSONArray array = (JSONArray)obj;

      System.out.println("The 2nd element of array");
      System.out.println(array.get(0));

      for (int i = 0; i < 83; i++) {
        JSONObject obj2 = (JSONObject) array.get(i);

        System.out.println(obj2.get("ID"));
        System.out.println(obj2.get("name"));
        System.out.println(obj2.get("attackType"));
        System.out.println(obj2.get("damageRange"));
        System.out.println(obj2.get("rank"));
        System.out.println(obj2.get("energyGiven"));
        System.out.println(obj2.get("counterMax"));

        if (obj2.get("counterMax").toString().equals("X")) {
          Monsters.add(new Abnormal((String) obj2.get("name"), (String) obj2.get("attackType"), (String) obj2.get("rank"), Integer.parseInt((String) obj2.get("ID")), 9));
        } else {
          Monsters.add(new Abnormal((String) obj2.get("name"), (String) obj2.get("attackType"), (String) obj2.get("rank"), Integer.parseInt((String) obj2.get("ID")), Integer.parseInt((String) obj2.get("counterMax"))));
        }
      }



    } catch (FileNotFoundException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return Monsters;

  }


  public static void main (String[] args) {
    parseAbnormalities();

  }

}
