import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

import Data.db;
import Model.Abnormal;
import Model.Agent;


public class Start {
    
   static ArrayList<Abnormal> abnormalities;
   static ArrayList<Agent> agents;
    public static void init(){
        try {
            abnormalities = db.getAbnormalitiesFromDB();
            System.out.println("Abnormalities successfully retrieved.");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve Abnormalities.");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void selectAbnormalities(){
       // int randInt = (int)(Math.random() * 5);
          ArrayList<Abnormal> abnoSelectionChoices = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randInt = (int)(Math.random() * 5);
            if (!abnoSelectionChoices.contains(abnormalities.get(randInt))) {
                 abnoSelectionChoices.add(abnormalities.get(randInt));     
            } else {
                randInt = (int)(Math.random() * 5);
                abnoSelectionChoices.add(abnormalities.get(randInt));     
            }
           
        }
       

    }


    public static void main(String[] args){
         System.out.println("Welcome to Lobotomy Corporation. Please press ENTER to begin the simulation.");

        agents = new ArrayList<>();
        abnormalities = new ArrayList<>();
        init();

         Scanner myObj = new Scanner(System.in);
       

        System.out.println("Generating new agent...");

        Agent sample = new Agent("Ernesto");
        agents.add(sample);

        System.out.println("Manager, please welcome " + sample.name + " to the company.");
       //  String actionNumber = "";

         while(!myObj.nextLine().equals("END")){
             String actionNumber = myObj.nextLine(); 
            System.out.println("What would you like to do? \n1) Generate a new agent.\n2) Start work.\n3) Select a new abnormality.\n4) Examine current agents.\n5) Examine current abnormalities.\n6) Quit");
          
            if (actionNumber.trim().equals("1")) {
                System.out.println("Generating new agent...");
            }
            
            if (actionNumber.trim().equals("2")) {
                System.out.println("Starting work...");
            }
            
            
            if (actionNumber.trim().equals("3")) {
                System.out.println("Selecting new abnormality...");
            }

            
            if (actionNumber.trim().equals("4")) {
                System.out.println("CURRENT AGENTS IN FACILITY: ");
                for (Agent a : agents) {
                    System.out.println(a.name + ", LEVEL: " + a.level + ", CURRENT HP: " + a.HP + "/" + a.MaxHP + ", CURRENT SP: " + a.SP + "/" + a.MaxSP + ", CURRENT ARMOR: none, CURRENT WEAPON: none");
                }
            }
           // actionNumber = myObj.nextLine(); 
         } //End while loop
      

    }

   
}
