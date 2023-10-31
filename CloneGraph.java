import java.util.*;
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;

        HashMap<Integer,Boolean> visit = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        HashMap<Integer,Node> hm = new HashMap<>();
        Node ng = new Node(node.val);
        Node head = ng;
        hm.put(node.val, head);

        while (!q.isEmpty()){
            Node tmp = q.remove();
            visit.put(tmp.val,true);

            for(Node nbr:tmp.neighbors){
                if(!visit.containsKey(nbr.val)){
                    q.add(nbr);
                    if(!hm.containsKey(nbr.val)){
                        Node nn = new Node(nbr.val);
                        hm.put(nbr.val,nn);
                    }
                    hm.get(tmp.val).neighbors.add(hm.get(nbr.val));
                    hm.get(nbr.val).neighbors.add(hm.get(tmp.val));
                }
            }
        }
        return head;


    }
}
