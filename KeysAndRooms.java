import java.util.*;
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean []visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()){
            int t = q.remove();
            for(int key:rooms.get(t)){
                if(visited[key]==false) {
                    q.add(key);
                    visited[key] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i]==false)
                return false;
        }
        return true;
    }
}
