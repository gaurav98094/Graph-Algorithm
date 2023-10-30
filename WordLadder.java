import  java.util.*;
// https://leetcode.com/problems/word-ladder/description/
// 127. Word Ladder
public class WordLadder {
    public int wordDiff(String s1,String s2){
        int ans=0;
        if(s1.length()!=s2.length())
            return Integer.MAX_VALUE;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                ans++;
        }
        return ans;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        wordList.add(beginWord);
        int si=0,ei=-1;

        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(beginWord))
                si=i;
            if(wordList.get(i).equals(endWord))
                ei=i;
        }

        int m = wordList.size();
        int dist[][] = new int[m][m];

        for(int i=0;i< wordList.size();i++){
            for(int j=0;j<wordList.size();j++){
                dist[i][j]=wordDiff(wordList.get(i),wordList.get(j));
            }
        }
        boolean visited[] = new boolean[m];
        int par[] = new int[m];
        Queue<Integer> q = new LinkedList<>();
        q.add(si);
        par[si] = 0;
        while (!q.isEmpty()){
            int tmp = q.remove();
            visited[tmp]=true;
            for(int i=0;i<m;i++){
                if(dist[tmp][i]==1 && visited[i]==false){
                    visited[i]=true;
                    par[i] = par[tmp]+1;
                    if(wordList.get(i).equals(endWord))
                        return par[i]+1;
                    q.add(i);
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        ArrayList<String> st = new ArrayList<>();
        st.add("hot");
        st.add("dot");
        st.add("dog");
        st.add("lot");
        st.add("log");
        st.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        WordLadder ob = new WordLadder();
        System.out.println(ob.ladderLength(beginWord,endWord,st));
    }
}
