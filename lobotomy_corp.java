
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


  private static ArrayList<Abnormal> allThings(){
    /** HE Class */
    Abnormal bulletMan = new HE("Der Freischütz", "black", "HE", 169);
    IDNums.add(bulletMan.ID);
    Monsters.add(bulletMan);
    inFacility.add(bulletMan);
    energyNeeded = 50;

    Abnormal butterflyCoffinMan = new HE("Funeral of the Dead Butterflies", "white", "HE", 168);
    IDNums.add(butterflyCoffinMan.ID);
    Monsters.add(butterflyCoffinMan);
    inFacility.add(butterflyCoffinMan);

    Abnormal LittleHelper = new HE("Little Helper", "red", "HE", 541);
    IDNums.add(LittleHelper.ID);
    Monsters.add(LittleHelper);
    inFacility.add(LittleHelper);


    return Monsters;
  }



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
        JSONObject obj2 = (JSONObject)array.get(i);

        System.out.println(obj2.get("ID"));
        System.out.println(obj2.get("name"));
        System.out.println(obj2.get("attackType"));
        System.out.println(obj2.get("damageRange"));
        System.out.println(obj2.get("rank"));
        System.out.println(obj2.get("energyGiven"));
        System.out.println(obj2.get("counterMax"));

        Monsters.add(new Abnormal((String) obj2.get("name"), (String) obj2.get("attackType"), (String) obj2.get("rank"), Integer.parseInt((String) obj2.get("ID")), Integer.parseInt((String) obj2.get("counterMax"))));
      }



    } catch (FileNotFoundException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  return Monsters;
  
}

  public static void displayAbnorm(){
    System.out.println("Current Abnormalities in the facility:");
    for(int i = 0; i< inFacility.size(); i++){
      System.out.print(inFacility.get(i).name + ", ");
    }
    System.out.println();
  }

  public static void displayAgentStats(){
    System.out.println("Current statuses of Agents in the facility: ");
    for(int i = 0; i< workers.size(); i++){
      System.out.println("Name: " + workers.get(i).name);
      System.out.println("Level: " + workers.get(i).level);
      System.out.println("HP: " + workers.get(i).HP);
      System.out.println("SP: " + workers.get(i).SP);
    }

  }
  public static void displayAgents(){
    System.out.println("Current Agents in the facility:");
    for(int i = 0; i< workers.size(); i++){
      System.out.print(workers.get(i).name + ", ");
    }
    System.out.println();
  }

  public static void working(ArrayList<Agent> people){
    Scanner in = new Scanner(System.in);
    System.out.println("It's time to begin the day. Send agents to work with abnormalities to harvest energy.");
    System.out.println();
    displayAbnorm();
    System.out.println();
    System.out.println("Please select an abnormality to work with.");
    String choiceA = in.nextLine();

    System.out.println("Please select an agent to work with " + choiceA);
    displayAgents();
    String choiceP = in.nextLine();


    System.out.println("Please select a work type for " + choiceP + " to work with " + choiceA + " on.");

    System.out.println();
    String choiceD = in.nextLine();

    System.out.println("Send " + choiceP + " to work on " + choiceD + " with " + choiceA + "? \n Y/N");
    Abnormal temp;

    for ( Abnormal a: Monsters) {
      if(a.name.equals(choiceA)){
        temp = a;
        for (Agent b: workers) {
          if(b.name.equals(choiceP)) {
            b.damage(b, temp);
          }
        }
        break;
      }
    }

  }

  public static void manageAsiyah(){
    Scanner in = new Scanner(System.in);

    System.out.println("Select a department to expand: [Control, Information, Training, Safety]. \n Enter 'read more <department> for more information.");
    String dept = in.nextLine();
    while(!dept.equals("Control") && !dept.equals("Information") && !dept.equals("Training") && !dept.equals("Safety")){
      System.out.println("Angela: 'Enter the name of a department to expand in order to exit this loop.'");
      if(dept.equals("read more Control")){
        System.out.println("The Control Team monitors the employees and Abnormalities and plans the best course of action. " +
                "They orders to other employees while watching the CCTV feeds. They tend to be bossy and assertive, making them unpopular among the other employees.");
      } else if(dept.equals("read more Information")){
        System.out.println("The Information Team analyzes the Abnormalities, profiles them, and devises solutions to issues the Abnormalities may cause based on the data. They are in charge of collecting, analyzing, and archiving observation data and interview logs provided by the Welfare Team. The vast library of data is the basis for finding “solutions” to various problems encountered in the energy harvesting process; they often conduct experiments to determine the consistency and safety of the solution.");
      } else if(dept.equals("read more Training")){
        System.out.println("The Training team is in charge of composing and regulating company policies and various management procedures. They also run general-purpose training programs to help employees adapt well to their new departments.");
      } else if(dept.equals("read more Safety")){
        System.out.println("The Safety Team gives safety training to new employees and develops action plans for all kinds of potential emergencies that can occur in the company. They establish strategies for situations such as escaping Abnormalities, panicking employees and security breaches, as well as setting up safety guidelines for others to follow. They are notably meticulous and punctual.");
      }
      dept = in.nextLine();
    }
    System.out.println("Returning to Hub...");
  }


  public static void selectAbnorm(){
    System.out.println("Please select an Abnormality to place in the Facility.");
    for(int i = 0; i < 3; i++){

    }
    System.out.println(IDNums.get(0) + " " + IDNums.get(1) + " " + IDNums.get(2));

    Scanner in = new Scanner(System.in);
    int choice = in.nextInt();
   // inFacility.add(abnormDict.get(choice));

  }

  public void testHE(){

  }

  public static void main(String[] args) {

    parseAbnormalities();
/**
    Scanner in = new Scanner(System.in);
    System.out.println("Lobotomy Corporation Simulator...");
    LOB = 15;

    System.out.println();

    System.out.println("Please enter the number of Agents you would like to hire today: ");

    //--------------------------------Initialize everything---------------------------------
    allThings();
    int makeThese = in.nextInt();
    HireAgents();
    //initAbnorm(makeThese);
    System.out.println();
    selectAbnorm();
    System.out.println();
    //----------------END INITIALIZATION---------------
    displayAbnorm();
    System.out.println();
    displayAgents();
    System.out.println();

*/

  }

}
