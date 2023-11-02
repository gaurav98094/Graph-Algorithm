public class IsGraphBipartite {

    public boolean dfs_helper(int graph[][],int node,int visited[],int parent,int color){
        visited[node] = color;
        
        for(int nbr:graph[node]){
            if(visited[nbr]==0){
                boolean subprob = dfs_helper(graph,nbr,visited,node,3-color);
                if(subprob==false)
                    return false;
            } else if (nbr!=parent && color==visited[nbr]) {
                return false;
            } else if (nbr==node) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {


        int n = graph.length;
        int visited[] = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                boolean ans = dfs_helper(graph,i,visited,-1,1);
                if(ans==false)
                    return false;
            }
        }
        return true;
    }
}
