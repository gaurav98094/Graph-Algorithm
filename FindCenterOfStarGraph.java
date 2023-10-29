
//https://leetcode.com/problems/find-center-of-star-graph/description/
// 1791. Find Center of Star Graph
public class FindCenterOfStarGraph {
        public int findCenter(int[][] edges) {
            int first[] = edges[0];
            int second[] = edges[1];

            if(first[0]==second[0] || first[0]==second[1])
                return first[0];
            return first[1];
        }

}
