import java.util.*;
public class FindEventualSafeState {
    public boolean hasCycle(int src,int graph[][],boolean visited[]){
//        System.out.println(src);
        visited[src]= true;
        for(int nbr:graph[src]){

            if(visited[nbr]==false){
                boolean ans = hasCycle(nbr,graph,visited);
                visited[nbr] = false;
                if(ans==true)
                    return true;
            }else{
                return true;
            }
        }
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = graph.length;
        int ck[] = new int[n];

        for(int i=0;i<n;i++){
            boolean visited[] = new boolean[n];
            boolean aa = false;
            if(ck[i]==0) {
                aa = hasCycle(i, graph, visited);
            } else if (ck[i]==1) {
                aa = false;
            }else {
                aa = true;
            }
//            System.out.println(aa);
            if(!aa){
                ans.add(i);
                for(int kk=0;kk<n;kk++){
                    if(visited[kk]==true)
                        ck[kk] = 1;
                }
            }else{
                for(int kk=0;kk<n;kk++)
                    if(visited[kk]==true)
                        ck[kk]=-1;
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
