public class CycleUndirected extends Graph<Integer>{
    public boolean dfs(boolean visited[],int node,int parent){
        visited[node] = true;
        for(int nbr:hm.get(node)){
            if(!visited[nbr]){
                boolean containCycle = dfs(visited,nbr,node);
                if(containCycle)
                    return true;
            } else if (parent!=nbr) {
                return true;
            }
        }
        return false;
    }
    boolean containsCycle(){
        boolean []visited = new boolean[10];
        return dfs(visited,0,-1);
    }
    public static void main(String[] args) {
        CycleUndirected g = new CycleUndirected();
        g.addEdge(1,2);
        g.addEdge(2,3);
//        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(3,4);
        g.addEdge(1,0);
//        g.addEdge(0,4);
        g.addEdge(4,5);
//        g.printGraph();
//        System.out.println("Traversal ");
        System.out.println(g.containsCycle());
//        System.out.println(" NULL ");
    }
}
