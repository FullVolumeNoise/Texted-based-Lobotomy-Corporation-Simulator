import java.util.ArrayList;

public class Department {
    static ArrayList <Agent> Agents;
    ArrayList <Abnormal> Abnos;

    public static String deptName;
    public int capacity = 6;
    public Department(String deptName){
    this.deptName = deptName;
    }

    public static String addAgentToDept(Agent agent){
        Agents.add(agent);
        return agent.name + " has been added to " + deptName;
    }

    public static String removeAgentFromDept(Agent agent){
        if(Agents.contains(agent)){
            Agents.remove(agent);
            return agent.name + " was removed from " + deptName;
        }
        return agent.name + " is not placed in " + deptName + " department.";

    }
}
