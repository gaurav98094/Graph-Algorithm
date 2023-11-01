import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathAlternateCOlor {

    class trio{
        int dest;
        int color;
        int len;

        trio(int a,int b,int c){
            dest = a;
            color = b;
            len = c;
        }
    }

    public int getLength(HashMap<Integer, ArrayList<Integer>> re ,HashMap<Integer, ArrayList<Integer>> be,int src,int dest,int n){
        boolean rv[] = new boolean[n];
        boolean bv[] = new boolean[n];
        Queue<trio> q = new LinkedList<>();
        q.add(new trio(src,1,0));
        q.add(new trio(src,2,0));
        rv[src]  = true;
        bv[src] = true;

        int i = 0;
        while (!q.isEmpty()){
            i++;
            trio tmp = q.remove();

            if(tmp.dest==dest)
                return tmp.len;

            if(tmp.color==1){
                for(int nbr:re.get(tmp.dest)){
                    if(bv[nbr]==false) {
                        bv[nbr]=true;
                        q.add(new trio(nbr, 2, tmp.len + 1));
                    }
                }
            }else{
                for(int nbr:be.get(tmp.dest)){
                    if(rv[nbr]==false) {
                        rv[nbr] = true;
                        q.add(new trio(nbr, 1, tmp.len + 1));
                    }
                }
            }
        }
        return -1;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        HashMap<Integer, ArrayList<Integer>> re = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> be = new HashMap<>();
        for(int i=0;i<n;i++){
            re.put(i,new ArrayList<>());
            be.put(i,new ArrayList<>());
        }

        for(int arr[]:redEdges){
            re.get(arr[0]).add(arr[1]);
        }
        for(int arr[]:blueEdges){
            be.get(arr[0]).add(arr[1]);
        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++)
            ans[i] = getLength(re, be,0,i,n);

        return ans;
    }
}
