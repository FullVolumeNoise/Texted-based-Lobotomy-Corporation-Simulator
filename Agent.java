import java.util.ArrayList;
import java.lang.*;
public class Agent {
  public int SP;
  public int HP;
  public int level;
  private String[] names;
  public String name;
  public int MaxHP;
  public int MaxSP;
  public int  temperence;
  public int justice;

  public Agent(){
    temperence = 1;
    justice = 1;
    SP =  (int)(Math.random() * (10)+10);
    MaxHP =  (int)(Math.random() * (10)+15);
    level = 1;
    name = nameGenerator();
    HP = MaxHP;
  }

  public Agent(String name){
    temperence = 1;
    justice = 1;
    SP =  (int)(Math.random() * (10)+10);
    MaxHP =  (int)(Math.random() * (10)+15);
    level = 1;
    this.name = name;
    HP = MaxHP;
  }


  public String nameGenerator(){
    names = new String[]{"Daniel", "Mika", "Allen", "Viktor", "Jack", "Nick", "Ellen", "Susan", "Rogun", "Onorio", "Camille","Basil", "Dennis", "Ricardo", "Rikka" };
    int ran = (int)(Math.random() * (names.length));
    return names[ran];
  }

  public void damage(Agent person, Abnormal creature){
    /**
     * RED: Targets Health Points.
     * WHITE: Targets Sanity Points.
     * BLACK: Targets Health and SP Sanity Points.
     * PALE: Targets Health Points for a percentage of the employee's Max HP.
     * */

    if(creature.rank == "ZAYIN"){
      if(creature.damageType == "Red") {
        person.HP -= 1;
      }
      else if(creature.damageType == "White") {
        person.SP -= 1;
      }
      else if(creature.damageType == "Black") {
        person.HP -= 1;
        person.SP -=1 ;
      }
      else if(creature.damageType == "Pale") {
        person.HP -= 1;
      }
    }

    if(creature.rank == "TETH"){
     if(creature.damageType == "Red") {
        person.HP -= 2;
      }
      else if(creature.damageType == "White") {
        person.SP -= 2;
      }
      else if(creature.damageType == "Black") {
        person.HP -= 2;
        person.SP -=2 ;
      }
      else if(creature.damageType == "Pale") {
        person.HP -= 2;
      }
    }

    if(creature.rank == "WAW"){
      if(creature.damageType == "Red") {
        person.HP -= 3;
      }
      else if(creature.damageType == "White") {
        person.SP -= 3;
      }
      else if(creature.damageType == "Black") {
        person.HP -= 3;
        person.SP -=3 ;
      }
      else if(creature.damageType == "Pale") {
        person.HP -= 3;
      }
    }

    if(creature.rank == "ALEPH"){
      if(creature.damageType == "Red") {
        person.HP -= 4;
      }
      else if(creature.damageType == "White") {
        person.SP -= 4;
      }
      else if(creature.damageType == "Black") {
        person.HP -= 4;
        person.SP -=4 ;
      }
      else if(creature.damageType == "Pale") {
        person.HP -= 4;
      }
    }

  }

  public void fortitudeUp(Agent person){
    person.MaxHP += 1;

  }
  public void TempUp(Agent person){
    person.temperence += 1;

  }

  public void sanityUp(Agent person){
    person.MaxSP += 1;

  }

  public void justiceUp(Agent person){
    person.justice += 1;

  }
  
}
