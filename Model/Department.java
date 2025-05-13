package Model;
import java.util.ArrayList;

public class Department {
    ArrayList<Agent> Agents; //limit to 5
    ArrayList<Abnormal> Abnos; //limit to 4

    public String deptName;

    public Department(String deptName){
        this.deptName = deptName;
    }

    public String addAgentToDept(Agent agent){
        Agents.add(agent);
        return agent.name + " has been added to " + deptName;
    }

    public String removeAgentFromDept(Agent agent){
        if(Agents.contains(agent)){
            Agents.remove(agent);
            return agent.name + " was removed from " + deptName;
        }
        return agent.name + " is not placed in " + deptName + " department.";

    }

    public String addMonsterToDept(Abnormal monster) {
        Abnos.add(monster);
        return monster.ID + " has been added to " + deptName + " department.";
    }



}
