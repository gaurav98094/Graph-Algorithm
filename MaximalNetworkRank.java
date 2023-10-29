// https://leetcode.com/problems/maximal-network-rank/description/
public class MaximalNetworkRank {
    int maximalNetworkRank(int n, int[][] roads) {
        //Find the degree
        int []deg = new int[n];
        int [][]dir = new int[n][n];

        for(int []road:roads){
            deg[road[0]]++;
            deg[road[1]]++;
            dir[road[0]][road[1]] = 1;
            dir[road[1]][road[0]] = 1;
        }

        int rank = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                rank = Math.max(rank,deg[i]+deg[j]-dir[i][j]);
            }
        }
        return rank;
    }
}
