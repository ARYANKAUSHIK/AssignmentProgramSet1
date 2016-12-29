/* PROBLEM 1
Linked List
Implement an algorithm to delete a node in the middle of a singly linked list, given only access
to that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a- >b- >d->e 

*/
/*
Steps:-
1st> Approach is tricky and simple
2nd> Copy the value of next node to the node which you want to delete
3rd> Delete the next node*/

 import java.util.Scanner;
 class LinkedListDeleteQ1{
	    @SuppressWarnings("unchecked") 
    private static void deleteMiddleNode(LinkedList.Node node){
        if(node.next == null)return; //End node provided to LinkedList
        LinkedList.Node prev = node;
        node = node.next;
        
        while(node.next!=null){
            prev.value = node.value;
            prev = node; node = node.next;
        } 
        prev.value = node.value;
        prev.next = null;
    }
     //@SuppressWarnings({"unchecked", "unsafe"})
    private static <T> LinkedList<T>.Node selectMiddleNode(LinkedList<T> ll, int index){
        LinkedList<T>.Node node = ll.head;
        for(int i=0;node.next!=null && i<=index-1;++i){
            node = node.next;
        }
        return node;   
    }
    public static <T> LinkedList<T> buildList(T[] a){ 
        LinkedList<T> ll = new LinkedList<>();
        for(T t:a){ll.add(t);}
        return ll;
    }
    // @SuppressWarnings({"unchecked", "unsafe"})
    public static void main(String[] args){
       /* Scanner in = new Scanner(System.in);
          System.out.println("Enter the character in LinkedList");
          char[] array = in.nextLine().toCharArray();
        */        
	    Character array[] = new Character[]{'A','E','I','O','U'};
		LinkedList<Character> ll = buildList(array);
		System.out.println("The Linked List is as follows :" +ll);
		Scanner in = new Scanner(System.in);
          System.out.println("Enter the position in LinkedList which you want to delete, where index is 0 :");
           int x = in.nextInt();  
        LinkedList<Character>.Node node = selectMiddleNode(ll, x);
        deleteMiddleNode(node);
        System.out.println("The new LinkedList is :"+ll);
    }
}
class LinkedList <T>{
    Node head;
    class Node{
        
	Node next;
        T value;   
        Node(T value){this.value = value;}
    } 
	public boolean isEmpty(){
        return head==null;
    }
	
    public void add(T value){
        if(head==null){head = new Node(value); return;}
        Node t = head;
        while(t.next!=null){t = t.next;}
        t.next = new Node(value); 
    }
	
    public String toString(){
        StringBuilder bf = new StringBuilder();
        Node t = head;
        while(t!=null){
            bf.append(t.value);
            t = t.next;
        }
        return bf.toString();
    }
}
