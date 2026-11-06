import java.util.*;
class DisjointSet {
    int[] rank, parent, size;

    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // 1. INITIALIZE DSU → EACH ACCOUNT INDEX IS A SEPARATE NODE
        DisjointSet ds = new DisjointSet(n);

        // 2. INITIALIZE HASHMAP → STORE {EMAIL → ACCOUNT INDEX}
        Map<String, Integer> mapMailNode = new HashMap<>();

        // 3. TRAVERSE ACCOUNTS → VISIT EVERY ACCOUNT
        for (int i = 0; i < n; i++) {

            // 4. TRAVERSE EMAILS → START FROM INDEX 1 (SKIP NAME)
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                // 5. NEW EMAIL → STORE {EMAIL, CURRENT ACCOUNT INDEX}
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                }

                // 6. EXISTING EMAIL → UNION BOTH ACCOUNT INDICES
                else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // 7. INITIALIZE MERGED LIST → EMPTY EMAIL LIST FOR EVERY ACCOUNT
        List<List<String>> mergedMail = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        // 8. TRAVERSE HASHMAP → FIND ULTIMATE PARENT
        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());

            // 9. GROUP EMAILS → ADD TO ULTIMATE PARENT'S LIST
            mergedMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        // 10. SORT EMAILS → SORT INSIDE EVERY COMPONENT
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).isEmpty()) continue;

            Collections.sort(mergedMail.get(i));

            // 11. ADD NAME → OWNER'S NAME AT INDEX 0
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));

            ans.add(temp);
        }

        // 12. SORT ACCOUNTS → SORT FINAL ACCOUNTS BY NAME
        ans.sort(Comparator.comparing(list -> list.get(0)));

        // 13. RETURN ANSWER
        return ans;
    }
}
