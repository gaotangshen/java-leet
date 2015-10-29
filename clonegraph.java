/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 *    
 */
  // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
  //       if(node == null)
  //           return null;
            
  //       HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
  //       UndirectedGraphNode head = new UndirectedGraphNode(node.label);
  //       hm.put(node, head);
        
  //       DFS(hm, node);//DFS
  //       return head;
  //   }
  //   public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
  //       if(node == null)
  //           return;
            
  //       for(UndirectedGraphNode aneighbor: node.neighbors){ 
  //           if(!hm.containsKey(aneighbor)){
  //               UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
  //               hm.put(aneighbor, newneighbor);
  //               DFS(hm, aneighbor);//DFS
  //           }
  //           hm.get(node).neighbors.add(hm.get(aneighbor));
  //       }
  //   }
// public class Solution {
    // public void dfs(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> hm){
    //     for(UndirectedGraphNode aneighbor: node.neighbors){ 
    //         if(!hm.containsKey(aneighbor)){
    //             UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
    //             hm.put(aneighbor,newneighbor);
    //             dfs(aneighbor,hm);
    //         }
    //         hm.get(node).neighbors.add(hm.get(aneighbor));
            
    //     }

    // }
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if(node == null)
    //         return null;
    //     UndirectedGraphNode head = new UndirectedGraphNode(node.label);
    //     HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    //     hm.put(node, head);
    //     dfs(node,hm);
    //     return head;
    // }
// }
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node==null){
            return null;
        }
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm= new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode head = BFS(node,hm);
        return head;
    }
    public UndirectedGraphNode BFS(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> hm){
        UndirectedGraphNode n = new UndirectedGraphNode(node.label);
        hm.put(node,n);
        for(UndirectedGraphNode aneighbor : node.neighbors){
            if(!hm.containsKey(aneighbor)){
                // UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                // hm.put(aneighbor,newneighbor);
                n.neighbors.add(BFS(aneighbor,hm));
            }else{
                n.neighbors.add(hm.get(aneighbor));
            }
            
        }
        return n;
    }
}

