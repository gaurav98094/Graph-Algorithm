public class DisjointSetUnion {
    int parent[];
    DisjointSetUnion(int n) {
        parent = new int[n];
    }

    int find(int i){
        if(parent[i]==-1){
            return i;
        }

        return find(parent[i]);
    }


    void union(int a,int b){
        int s1= find(a);
        int s2 = find(b);

        // Edit here to check for cycle
        if(s1!=s2){
            parent[s2]=s1;
        }
    }
}
