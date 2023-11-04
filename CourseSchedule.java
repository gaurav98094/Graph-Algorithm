import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int indeg[] = new int[n];
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++)
            hm.put(i,new ArrayList<>());

        for(int arr[]:prerequisites){
            indeg[arr[0]]++;
            hm.get(arr[1]).add(arr[0]);
        }


        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0)
                q.add(i);
        }


        while (!q.isEmpty()){
            int tmp = q.remove();
            visited[tmp] = true;
            for(int nbr:hm.get(tmp)){
                indeg[nbr]--;
                if(indeg[nbr]==0)
                    q.add(nbr);
            }
        }

        for(int i=0;i<n;i++)
            if(visited[i]==false)
                return false;

        return true;

    }
}
