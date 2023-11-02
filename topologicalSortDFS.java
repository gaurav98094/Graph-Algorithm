import java.util.LinkedList;
import java.util.Queue;

public class topologicalSortDFS extends GraphDirected<Integer> {

    public void topological(int src,boolean visited[]){
        visited[src] = true;

        for(int nbr:hm.get(src)){
            if(visited[nbr]==false){
                topological(nbr,visited);
//                System.out.print(nbr+" --> ");
            }
        }
        System.out.print(src+" --> ");

    }

    public static void main(String[] args) {
        topologicalSortDFS g = new topologicalSortDFS();
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(1,4);
        g.addEdge(1,2);
        g.printGraph();

        boolean visited[] = new boolean[6];
        System.out.println("----------------------------");
        for(int i=0;i<6;i++) {
            if(visited[i]==false) {
                g.topological(i, visited);
//                System.out.print(i + " --> ");
            }
        }


    }
}
