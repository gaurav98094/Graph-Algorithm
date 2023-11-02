import java.util.LinkedList;
import java.util.Queue;


public class TopologicalSort extends GraphDirected<Integer> {

    public void topological(){
        int n = hm.size();
        int indeg[] = new int[n];

        for(int i=0;i<n;i++){
            for(int nbr:hm.get(i)){
                indeg[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(indeg[i]==0)
                q.add(i);

        while (!q.isEmpty()){
            int tmp = q.remove();
            System.out.print(tmp+ " --> ");
            for(int nbr:hm.get(tmp)){
                indeg[nbr]--;
                if(indeg[nbr]==0)
                    q.add(nbr);
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort();
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(1,4);
        g.addEdge(1,2);
        g.printGraph();

        System.out.println("----------------------------");
        g.topological();


    }
}
