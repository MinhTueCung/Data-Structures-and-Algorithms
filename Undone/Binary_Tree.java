package Undone;

public class Binary_Tree {
   class Node{
       int value;
       Node left, right;
       public Node(int value){
           this.value = value;
           left = null;
           right = null;
       }
   }
   Node root;
   public void Addroot(int value){
       root = new Node(value);
   }
   private Node Add_recur(Node current, int value){
       if(current == null){
           return new Node(value);
       }
       else{
           if(value < current.value){
               current.left = Add_recur(current.left, value);
           }
           if(value > current.value){
               current.right = Add_recur(current.right, value);
           }
           if(value == current.value){
              System.out.println("Already exists!");
           }
           return current;
       }
   }
   public void Add(int value){
       Add_recur(root, value);
   }
   private boolean Contain_recur(Node current, int value){
       if(current == null){
           return false;
       }
       else{
           if(value < current.value){
               return Contain_recur(current.left, value);
           }
           if(value > current.value){
               return Contain_recur(current.right, value);
           }
           else{
               return true;
           }
       }
   }
   public boolean Contain(int value){
       return Contain_recur(root, value);
       }
   private int anzahl = 0;
   private int Preorder_recur(Node current){
      if(current != null){
          anzahl++;
          Preorder_recur(current.left);
          Preorder_recur(current.right);
      }
      return anzahl;
   }
   public void Anzahl(){
       System.out.println(Preorder_recur(root));
   }
   public void showNode(Node node){
       System.out.println(node.value);
   }
   private Node Del_recur(Node current, int value){
       if(current == null){
           System.out.println("Node not found!");
           return null;
       }
       else{
           if(value < current.value){
               current.left = Del_recur(current.left, value);
           }
           if(value > current.value){
               current.right = Del_recur(current.right, value);
           }
           else{
               if(current.left == null && current.right == null){
                   return null;
               }
               if(current.left == null){
                   return current.right;
               }
               if(current.right == null){
                   return current.left;
               }
               else{
                  if(current.left.right == null){
                      return current.left;
                  }
                  else{
                      Search_Max_SubTree_null(current.left);
                      
                      return Search_Max_SubTree(current.left);
                  }
               }
           }
       }
     return current;
   }
   private Node Search_Max_SubTree_null(Node current){
       if(current.right == null){
           if(current.left != null){
               return current.left;
           }
           else{
               return null;
           }
       }
       else{
           current.right = Search_Max_SubTree_null(current.right);
           return current;
       }
   }
   private Node Search_Max_SubTree(Node current){
       if(current.right == null){
           return current;
       }
       else{
           return Search_Max_SubTree(current.right);
       }
   }
   public void Del(int value){
       Del_recur(root, value);
   }
 }

 

