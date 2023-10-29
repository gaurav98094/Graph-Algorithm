public class AdjascencyListRepresentation {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.printGraph();
    }
}
