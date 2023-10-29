// https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/
// 1761. Minimum Degree of a Connected Trio in a Graph
public class MinimumDegreeOfConnectedTrioGraph {
    public int minTrioDegree(int n, int[][] roads) {

        int []deg = new int[n+1];
        int [][]dir = new int[n+1][n+1];

        for(int []road:roads){
            deg[road[0]]++;
            deg[road[1]]++;
            dir[road[0]][road[1]] = 1;
            dir[road[1]][road[0]] = 1;
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=j+1;k<=n;k++){
                    if(dir[i][j]==1 && dir[j][k]==1 && dir[i][k]==1)
                        ans = Math.min(ans,deg[i]+deg[j]+deg[k]-6);
                }
            }
        }

        if(ans==Integer.MAX_VALUE)
            ans=-1;
        return ans;
    }
}
