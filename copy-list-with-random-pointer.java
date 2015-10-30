/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//recursive method.
public class Solution {
    public Map<RandomListNode, RandomListNode> hm ;   // works when change HashMap to Map.
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode root = new RandomListNode(head.label);
        hm = new HashMap<RandomListNode,RandomListNode>();
        hm.put(head,root);
        DFS(head);
        return root;
    }
    public void DFS(RandomListNode head){
        if(head==null){
            return ;
        }
        if(head.next != null){
            RandomListNode node = new RandomListNode(head.next.label);
            hm.put(head.next,node);
            DFS(head.next);
            hm.get(head).next = hm.get(head.next);
        }
        RandomListNode randomnode = null;
        if(head.random!=null){
            randomnode = hm.get(head.random);
        }
        hm.get(head).random = randomnode;
    }
    // public HashMap<RandomListNode, RandomListNode> createdNode ; 
    // public RandomListNode DFS(RandomListNode node){
    //     if(node==null){
    //         return null;
    //     }
    //     RandomListNode newNode = new RandomListNode(node.label);
    //     createdNode.put(node,newNode);
    //     newNode.next = DFS(node.next);
    //     RandomListNode randomnode = null;
    //     if(node.random!=null){
    //         randomnode = createdNode.get(node.random);
    //     }
    //     newNode.random = randomnode;
    //     return newNode;
    // }
    
    //  public RandomListNode copyRandomList(RandomListNode head) {
    //     if(head==null){
    //         return null;
    //     }
    //     createdNode = new HashMap<RandomListNode,RandomListNode>();
    //     return DFS(head);
    // }
}
//better user loop 