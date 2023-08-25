import java.util.ArrayList;

public class Abnormal {
  String name;
  String quote;
  String rank;
  String damageType;
  int ID;
  String workResult;
  int energyBoxMax;
  int energyBoxesProduced;
  int levelMin;

  int counterMax;
  boolean canEscape;
  ArrayList<String> tips;
  String escapeType;
  public int damageAmt;

  /**
   * RANKS: ZAYIN, TETH, HE, WAW, ALEPH
   * Damage Type: RED, WHITE, BLACK, PALE
   * */
  public Abnormal(String name, String damageType, String rank, int ID, int counterMax){
    this.name = name;
    this.damageType = damageType;
    this.rank = rank;
    this.ID = ID;
    this.counterMax = counterMax;
    tips =  new ArrayList<>();

    if(this.rank.equals("ZAYIN")){
      this.energyBoxMax = 10;
      this.levelMin = 1;
    } else if(this.rank.equals("TETH")){
      this.energyBoxMax = 14;
      this.levelMin = 1;
    } else if(this.rank.equals("HE")){
      this.energyBoxMax = 18;
      this.levelMin = 2;
    } else if(this.rank.equals("WAW")){
      this.energyBoxMax = 20;
      this.levelMin = 3;
    } else{
      this.energyBoxMax = 30;
      this.levelMin = 4;
    }


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

  public String Fortitude(Agent person){
    if(rank.equals("TETH")){
      person.HP -= 3;
      person.MaxHP += 1;
    }
    if(rank.equals("HE")){
      if(person.level < levelMin){
        return person.name + "has died.";
      }
      person.HP -= 4;
      person.MaxHP += 1;
    }

    if(rank.equals("WAW")){
      if(person.level < levelMin){
        return person.name + "has died.";
      }
      person.HP -= 5;
      person.MaxHP += 2;
    }
    if(rank.equals("ALEPH")){
      if(person.level < levelMin){
        return person.name + "has died.";
      }
      person.HP -= 6;
      person.MaxHP += 5;
      lobotomy_corp.energyTotal += energyBoxesProduced;
    }
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

  public void lure(){

  }

  public String toString(){
    StringBuilder total;
    //total += name;
    return "";
  }
}
