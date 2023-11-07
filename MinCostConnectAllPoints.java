import java.util.*;
public class MinCostConnectAllPoints {
        public int distance(int p1[],int p2[]){
            return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
        }
        public int minCostConnectPoints(int[][] points) {
            int ans=0;
            int n = points.length;

            int dist[] = new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            int vis[] = new int[n];
            int k=0;

            int curr =0;
            vis[0]=1;

            while(k!=n-1){
                int min = Integer.MAX_VALUE,pos=curr;

                for(int i=0;i<n;i++){
                    dist[i] = Math.min(dist[i],distance(points[i],points[curr]));
                    if(dist[i]<min && vis[i]==0){
                        pos=i;
                        min=dist[i];
                    }
                }
                System.out.println(pos);
                System.out.println(Arrays.toString(dist));
                //System.out.println(dist[pos]);
                vis[pos]=1;
                k=k+1;
                ans=ans+dist[pos];
                curr = pos;

            }


            return ans;
        }


}
