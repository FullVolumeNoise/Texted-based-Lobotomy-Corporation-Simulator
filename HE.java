public class HE extends  Abnormal{

    public int escapePenalty = 3;
    public int EBoxes;
   public int damageAmt;

    /**
     * RANKS: ZAYIN, TETH, HE, WAW, ALEPH
     * Damage Type: RED, WHITE, BLACK, PALE
     *
     * @param name
     * @param damageType
     * @param rank
     * @param ID
     */
    public HE(String name, String damageType, String rank, int ID) {
        super(name, damageType, "HE", ID);
        EBoxes = (int) (Math.random() * 3) -15;
        damageAmt = (int) (Math.random()*4 - 2);
    }


    public String FortitudeMinimum(Agent person){
        if(person.MaxHP < 10){
            System.out.println( person.name + " works really hard to deal with the abnormality but....");
            System.out.println(person.name + " has failed.");
        }
        return person.name + "has died.";
    }

    public String SanityMinimum(Agent person){
        if(person.MaxSP < 10){
            System.out.println( person.name + " works really hard to deal with the abnormality but....");
            System.out.println(person.name + " has failed.");
        }
        return person.name + "has gone insane.";
    }

    public void redDamage(Agent person){
        person.HP -= damageAmt;
    }

    public void whiteDamage(Agent person){
        person.SP -= damageAmt;
    }

    public void blackDamage(Agent person){
        person.HP -= damageAmt;
        person.SP -= damageAmt;
    }

    public void paleDamage(Agent person){

    }

}
