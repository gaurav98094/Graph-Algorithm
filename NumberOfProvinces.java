// https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=graph-theory
public class NumberOfProvinces {
    public void helper(boolean visited[],int adj[][],int src){
        visited[src] = true;
        for(int i=0;i< adj.length;i++){
            if(adj[src][i]==1 && visited[i]==false)
                helper(visited,adj,i);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                ans++;
                helper(visited,isConnected,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int isCOnn[][] = {{1,1,0},{1,1,0},{0,0,1}};
        NumberOfProvinces ob = new NumberOfProvinces();
        System.out.println(ob.findCircleNum(isCOnn));
    }
}
