import java.util.LinkedList;
import java.util.Queue;

public class DFS extends Graph<Integer> {
    void traversal(boolean []visited, int src){
        visited[src] = true;
        System.out.print(src + " --> ");

        for(int key:hm.get(src)){
            if(visited[key]==false)
                traversal(visited,key);
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS();
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
        boolean []visited = new boolean[10];
        g.traversal(visited,0);
        System.out.println(" NULL ");

    }
}
