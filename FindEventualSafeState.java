import java.util.*;
public class FindEventualSafeState {
    public boolean hasCycle(int src,int graph[][],boolean visited[],boolean stack[]){
        visited[src]= true;
        stack[src] = true;
        for(int nbr:graph[src]){
            if(stack[nbr]==true)
                return true;

            if(visited[nbr]==false){
                boolean ans = hasCycle(nbr,graph,visited,stack);
                if(ans==true)
                    return true;
            }
        }
        stack[src] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = graph.length;
        int ck[] = new int[n];

        for(int i=0;i<n;i++){
            boolean visited[] = new boolean[n];
            boolean stack[] = new boolean[n];
            boolean aa = false;
            aa = hasCycle(i, graph, visited,stack);
            if(!aa){
                ans.add(i);
            }
        }
        return  ans;
    }


    public static void main(String[] args) {
        int g[][] = {{1,2},{2,3},{5},{0},{5},{},{}};
        FindEventualSafeState gg = new FindEventualSafeState();
        System.out.println(gg.eventualSafeNodes(g));
    }
}
