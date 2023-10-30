import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Graph<Integer>{

    void traversal(){
        boolean []visited = new boolean[10];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()){
            int t = q.remove();
            System.out.print(t+" --> ");
            for(int k:hm.get(t)){
                if(visited[k] == false) {
                    q.add(k);
                    visited[k]=true;
                }
            }
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        BFS g = new BFS();
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(3,4);
        g.addEdge(1,0);
        g.addEdge(0,4);
        g.addEdge(4,5);
        g.printGraph();


        System.out.println("Traversal ");
        g.traversal();

    }
}
