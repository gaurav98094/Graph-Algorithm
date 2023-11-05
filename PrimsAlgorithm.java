import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithm {

    static class Pair{
        int f,s;
        Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }


    static class Graph{
        int v;
        ArrayList<Pair> l[];
        Graph(int n){
            v = n;
            l = new ArrayList[n];
            for(int i=0;i<v;i++)
                l[i] = new ArrayList<>();
        }

        void add_edge(int x,int y,int w){
            l[x].add(new Pair(y,w));
            l[y].add(new Pair(x,w));
        }


        int primsAlgo(){
            Queue<Pair> ae = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.f - o2.f;
                }
            });

            boolean vis[] = new boolean[v];
            ae.add(new Pair(0,0));
            int ans = 0;

            while (!ae.isEmpty()){
                Pair tmp = ae.remove();

                int to = tmp.s;
                int wei = tmp.f;

                if(vis[to]==true){
                    continue;
                }

                ans += wei;
                vis[to] = true;

                for(Pair nae : l[to]){
                    if(!vis[nae.f]){
                        ae.add(new Pair(nae.s , nae.f));
                    }
                }
            }

            return ans;
        }
    }
}
