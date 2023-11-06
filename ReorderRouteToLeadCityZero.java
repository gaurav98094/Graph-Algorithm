import java.util.*;
public class ReorderRouteToLeadCityZero {
    public int minReorder(int n, int[][] connections) {

        HashMap<Integer,ArrayList<Integer>> oe = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> me = new HashMap<>();

        for(int arr[]:connections){
            int f = arr[0];
            int s = arr[1];
            if(!oe.containsKey(f)){
                oe.put(f,new ArrayList<>());
                me.put(f,new ArrayList<>());
            }

            if(!oe.containsKey(s)){
                oe.put(s,new ArrayList<>());
                me.put(s,new ArrayList<>());
            }
            oe.get(f).add(s);
            me.get(s).add(f);
        }

        boolean visited[] = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int ans = 0;

        while (!q.isEmpty()){
            int tmp = q.remove();

            for(int m:me.get(tmp)){
                if(visited[m]==false) {
                    visited[m] = true;
                    q.add(m);
                }
            }

            for(int o:oe.get(tmp)){
                if(visited[o]==false){
                    visited[o]=true;
                    q.add(o);
                    ans = ans+1;

                }
            }
        }
        return ans;
    }
}
