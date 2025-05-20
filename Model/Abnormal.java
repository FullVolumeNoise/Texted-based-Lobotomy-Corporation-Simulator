package Model;
import java.util.ArrayList;
import Data.db;

public class Abnormal {

  int ID;
  String name;
  String quote;
  String description;
  String rank;
  int counterMax;
  int currentCounter;
  int maxEnergyGiven;
  boolean canEscape;
  int armorsID;
  int weaponsID;
  int departmentID;
  boolean currentlyBreaching;
  String damageType;
 
  String workResult;
  int energyBoxesProduced;
  
  // ArrayList<String> tips;

  db connection = new db();

  int workCounter = 0;

  public void initializeAbnos(){
    

  }

  /**
   * RANKS: ZAYIN, TETH, HE, WAW, ALEPH
   * Damage Type: RED, WHITE, BLACK, PALE
   * */
  public Abnormal(int ID, String name, String rank,  int counterMax,  int currentCounter,
  int maxEnergyGiven, boolean canEscape, int armorsID, int weaponsID, int departmentID, boolean currentlyBreaching,
  String damageType){
    this.name = name;
    this.damageType = damageType;
    this.rank = rank;
    this.ID = ID;
    this.counterMax = counterMax;
    this.currentCounter = currentCounter;
    this.maxEnergyGiven = maxEnergyGiven;
    this.canEscape = canEscape;
    this.armorsID = armorsID;
    this.weaponsID = weaponsID;
    this.departmentID = departmentID;
    this.currentlyBreaching = currentlyBreaching;
    this.damageType = damageType;


  }

  public void createAbnormality(){

  }

  public void updateAbnormality(){

  }

  public void getAllAbnormalities(){
    
  }

  public void whiteWorkCycle(Agent person){}

  public void workCycle(Agent person){
    switch (this.rank) {
      case "ZAYIN":
        while (workCounter < 10 && person.HP != 0 && person.SP != 0) {
          if (this.damageType.equals("white")) {
            person.SP -= 1;
          } else if(this.damageType.equals("red") ) {
            person.HP -= 1;
          } else if(this.damageType.equals("black") ) {
            person.HP -= 1;
            person.SP -= 1;
          } else if(this.damageType.equals("pale") ) {
          person.HP -= person.MaxHP * 0.05; 
          }
          workCounter += 1;
        } //while loop
       
        break;
      
      case "TETH": 
        while (workCounter < 12 && person.HP != 0 && person.SP != 0) {

          if (this.damageType.equals("white")) {
            person.SP -= 1;
          } else if(this.damageType.equals("red") ) {
            person.HP -= 1;
          } else if(this.damageType.equals("black") ) {
            person.HP -= 1;
            person.SP -= 1;
          } else if(this.damageType.equals("pale") ) {
          person.HP -= person.MaxHP * 0.05; 
          }
          workCounter += 1;
        } //while loop

      case "HE":
        while (workCounter < 18 && person.HP != 0 && person.SP != 0) {

          if (this.damageType.equals("WHITE")) {
            person.SP -= 1;
          } else if(this.damageType.equals("RED") ) {
            person.HP -= 1;
          } else if(this.damageType.equals("BLACK") ) {
            person.HP -= 1;
            person.SP -= 1;
          } else if(this.damageType.equals("PALE") ) {
          person.HP -= person.MaxHP * 0.05; 
          }

          workCounter += 1;
      } //while loop


      case "WAW":
         while (workCounter < 22 && person.HP != 0 && person.SP != 0) {

        if (damageType.equals("white")) {
          person.SP -= 1;
        } else if(damageType.equals("red") ) {
          person.HP -= 1;
        } else if(damageType.equals("black") ) {
          person.HP -= 1;
          person.SP -= 1;
        } else if(damageType.equals("pale") ) {
         person.HP -= person.MaxHP * 0.05; 
        }
      
        workCounter += 1;
      } //while loop

      case "ALEPH":
        while (workCounter < 30 && person.HP != 0 && person.SP != 0) {

          if (damageType.equals("white")) {
            person.SP -= 1;
          } else if(damageType.equals("red") ) {
            person.HP -= 1;
          } else if(damageType.equals("black") ) {
            person.HP -= 1;
            person.SP -= 1;
          } else if(damageType.equals("pale") ) {
          person.HP -= person.MaxHP * 0.05; 
          }

          workCounter += 1;
        } //while loop

      default:
        workCounter = 0;
        break;
    }
 
    System.out.println( person.name + " has finished work with " + this.name + ".");
    System.out.println( "Their final health stats are: ");
    System.out.println( "Health: "+ person.HP);
    System.out.println( "Sanity: "+ person.SP);

  }



  public String statCheck(Agent person, String stat, int min, int max){
    if(stat.equals("temperence")){
      if(person.temperence < min){
          return person.name + " has died.";
      }
      if(person.temperence>max){
        return person.name + " has died.";
      }
    }

    if(stat.equals("fortitude")){
      if(person.MaxHP < min){
        return person.name + " has died.";
      }
      if(person.MaxHP>max){
        return person.name + " has died.";
      }
    }

    if(stat.equals("sanity")){
      if(person.MaxSP < min){
        return person.name + " has died.";
      }
      if(person.MaxSP>max){
        return person.name + " has died.";
      }
    }

    if(stat.equals("justice")){
      if(person.justice < min){
        return person.name + " has died.";
      }
      if(person.justice>max){
        return person.name + " has died.";
      }
    }


    return "";
  }

  public String fortitudeWork(Agent person){
    if(rank.equals("TETH")){
      person.HP -= 3;
      person.MaxHP += 1;
    }
    // if(rank.equals("HE")){
    //   if(person.level < levelMin){
    //     return person.name + "has died.";
    //   }
    //   person.HP -= 4;
    //   person.MaxHP += 1;
    // }

    // if(rank.equals("WAW")){
    //   if(person.level < levelMin){
    //     return person.name + "has died.";
    //   }
    //   person.HP -= 5;
    //   person.MaxHP += 2;
    // }
    // if(rank.equals("ALEPH")){
    //   if(person.level < levelMin){
    //     return person.name + "has died.";
    //   }
    //   person.HP -= 6;
    //   person.MaxHP += 5;
    // //  lobotomy_corp.energyTotal += energyBoxesProduced;
    // }
    //person.HP -= 1;
    if(person.HP <= 0){
      System.out.println( person.name + " works really hard to deal with the abnormality but....");
      return person.name + "has died.";
    }
      return person.name + " has finished work with " + name;
  }

  public String Sanity(Agent person){
    if(rank.equals("TETH")){
      person.SP -= 3;
      person.MaxSP += 1;
    }
    if(rank.equals("HE")){
      person.SP -= 4;
      person.MaxSP += 1;
    }

    if(rank.equals("WAW")){
      person.SP -= 5;
      person.MaxSP += 1;
    }
    if(rank.equals("ALEPH")){
      person.SP -= 6;
      person.MaxSP += 2;
    }
    //person.HP -= 1;
    if(person.SP <= 0){
      System.out.println( person.name + " works really hard to deal with the abnormality but....");
      return person.name + "has gone insane.";
    }
    return person.name + " has finished work with " + name;

  }


  // public String toString(){
  //   StringBuilder total;
  //   //total += name;
  //   return "";
  // }
}
