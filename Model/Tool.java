package Model;
public class Tool extends Abnormal{

    /**
     * RANKS: ZAYIN, TETH, HE, WAW, ALEPH
     * Damage Type: RED, WHITE, BLACK, PALE
     *
     * @param name
     * @param damageType
     * @param rank
     * @param ID
     */
    public Tool(String name, String damageType, String rank, int ID) {
        super(name, "None", rank, ID, 1 );
    }

    public void buff(Agent person){
        person.HP += 1;
    }

}
