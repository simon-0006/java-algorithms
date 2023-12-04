package Graphs;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

// with a given Adjacency List outputs the number of components -> could easily be modified to output all components
class Kosaraju
{
    boolean[] flag;
    ArrayList<ArrayList<Integer>> revAdj;
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        List<Integer> L = new LinkedList<>();
        flag = new boolean[V];
        
        // create list
        for (int v = 0; v < V; v++) {
            if (!flag[v]) DFS(adj, v, L);
            
        }
        
        // Reverse Adj list
        revAdj = new ArrayList<>();
        rev(adj, V);
        
        // We apply DFS on the reverse AdjList with L
        Arrays.fill(flag, false);
        int count = 0;
        for (int v = 0; v < L.size(); v++) {
            int nv = L.get(v);
            if (!flag[nv]) {
                count++;
                DFSrev(nv);
            }
        }
        
        
        return count;
    }
    
    // DFS
    private void DFS(ArrayList<ArrayList<Integer>> adj, int v, List<Integer> L) {
        
        flag[v] = true;
        
        for (int i = 0; i < adj.get(v).size(); i++) {
            if (!flag[adj.get(v).get(i)]) { DFS(adj, adj.get(v).get(i), L); }
        }
        
        L.add(0, v);
    }
    
    // Reverse Graph
    private void rev(ArrayList<ArrayList<Integer>> adj, int V) {
        
        // initialize
        for (int i = 0; i < V; i++) { revAdj.add(new ArrayList<Integer>()); }
        
        int v = 0;
        for (ArrayList a : adj) {
            if (a.size() != 0) {
                for (int n = 0; n < a.size(); n++) {
                    revAdj.get((int) a.get(n)).add(v);
                }
            }
            v++;
        }
        
    }
    
    // DFS 2
    private void DFSrev(int v) {
        flag[v] = true;
        for (Integer n : revAdj.get(v)) {
            if (!flag[n]) { DFSrev(n); }
        }
    }
    
}

