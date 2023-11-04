import java.util.*;
public class AllPathSrcToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(0)));

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int lastVertex = path.get(path.size() - 1);
            if (lastVertex == graph.length - 1) {
                ans.add(path);
            } else {
                for (int x : graph[lastVertex]) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(x);
                    q.offer(newPath);
                }
            }
        }

        return ans;
    }
}
