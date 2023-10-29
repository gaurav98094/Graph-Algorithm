import java.util.ArrayList;
import java.util.HashMap;

public class Graph<dt> {
    HashMap<dt,ArrayList<dt>> hm = new HashMap<>();




    void addEdge(dt i,dt j){
        if(!hm.containsKey(i)){
            hm.put(i,new ArrayList<>());
        }
        if(!hm.containsKey((j))){
            hm.put(j,new ArrayList<>());
        }
        hm.get(i).add(j);
        hm.get(j).add(i);
    }


    void printGraph(){
        for(dt key:hm.keySet()){
            System.out.print(key + " : ");
            for(dt nbr:hm.get(key)){
                System.out.print(nbr+ "  -- > ");
            }
            System.out.println(" NULL");
        }
    }

}
