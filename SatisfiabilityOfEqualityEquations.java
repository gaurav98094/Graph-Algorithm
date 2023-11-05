import java.util.ArrayList;
import java.util.Arrays;

public class SatisfiabilityOfEqualityEquations {
    int parent[] = new int[26];
    int rank[] = new int[26];
    int find(int i){
        if(parent[i]==-1)
            return i;
        return find(parent[i]);
    }

    void union(int a, int b){
        int s1 = find(a);
        int s2 = find(b);
        System.out.println(s1+".  "+s2);
        if(s1 != s2){
            if(rank[s1] < rank[s2]){
                parent[s1] = s2;
                rank[s2] += rank[s1];
            }else{
                parent[s2] = s1;
                rank[s1] += rank[s2];
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        Arrays.fill(parent,-1);
        Arrays.fill(rank,0);
        for(String st:equations){
            if(st.substring(1,3).equals("==")){
                int c1 = st.charAt(0)-'a';
                int c2 = st.charAt(3)-'a';
                union(c1,c2);
            }
        }

        for(String st:equations){
            if(!st.substring(1,3).equals("==")){
                int c1 = st.charAt(0)-'a';
                int c2 = st.charAt(3)-'a';
                if(find(c1)==find(c2))
                    return false;
            }
        }
        return true;
    }
}
