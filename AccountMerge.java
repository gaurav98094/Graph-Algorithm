import java.util.*;
public class AccountMerge {
    Set<String> visited = new HashSet<>();

    HashMap<String,List<String>> adjList = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // create the graph the from accounts
        for(List<String> account : accounts){
            // get(1) bcz 0 index is name
            String firstEmail = account.get(1);
            int accountSize = account.size();
            for(int index = 2;index < accountSize;index++){
                String email = account.get(index);
                if(!adjList.containsKey(firstEmail)){
                    adjList.put(firstEmail,new ArrayList<String>());
                }
                adjList.get(firstEmail).add(email);
                if(!adjList.containsKey(email)){
                    adjList.put(email, new ArrayList<String>());
                }
                adjList.get(email).add(firstEmail);
            }
        }
        // DFS from all the nodes
        List<List<String>> res = new ArrayList<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            // firstEmail
            String firstEmail = account.get(1);

            if (!visited.contains(firstEmail)){
                ArrayList<String> mergeAccount = new ArrayList<>();
                mergeAccount.add(name);
                DFS(mergeAccount,firstEmail);
                Collections.sort(mergeAccount.subList(1,mergeAccount.size()));
                res.add(mergeAccount);
            }

        }
        return res;

    }

    public void DFS(List<String>mergeAccount, String email){
        visited.add(email);
        mergeAccount.add(email);

        if (!adjList.containsKey(email)) {
            return;
        }

        for (String neighbour: adjList.get(email)){

            if(!visited.contains(neighbour)){
                DFS(mergeAccount,neighbour);
            }
        }
    }
}
