/*PROBLEM 2
Tower of Hanoi
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes
which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size
from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next tower.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using stacks.*/

/* ==>  The steps to follow are −

Step 1 − Move n-1 disks from source to aux
Step 2 − Move nth disk from source to dest
Step 3 − Move n-1 disks from aux to dest
A recursive algorithm for Tower of Hanoi can be driven as follows −

START
Procedure Hanoi(disk, source, dest, aux)

   IF disk == 0, THEN
      move disk from source to dest             
   ELSE
      Hanoi(disk - 1, source, aux, dest)     // Step 1
      move disk from source to dest          // Step 2
      Hanoi(disk - 1, aux, dest, source)     // Step 3
   END IF
   
END Procedure
STOP
*/


import java.util.*;
public class TowerOHanoi2 {
     private static ArrayList<Stack<Integer>> stacks = new ArrayList<>(3);
     public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
       System.out.print("Enter the number of Plates in TOH : ");
       int No_Of_Disk = sc.nextInt();
	   // int No_Of_Disk = 5;
        for (int i = 0; i < 3; i++) stacks.add(new Stack<>());
        Stack center = stacks.get(1); // 2nd Tower 
        // push All disks
        for (int i = No_Of_Disk; i > 0; i--) 
            stacks.get(0).push(i); 
		
        boolean SmallestMove = true;
        while (center.size() != No_Of_Disk) {
            if (SmallestMove)
                moveSmallestPart();
             else
                makeALegalMove();
            SmallestMove = !SmallestMove;
            displayStacksResults();
        }
    }
      public static void displayStacksResults() {
        System.out.println(" Tower of Hanoi Shifting is Follows :");
        for (Stack stack : stacks) {
            System.out.println(stack);
        }
        System.out.println("");
    }
    public static void makeALegalMove() {

        ArrayList<Stack<Integer>> excludeSmallest = new ArrayList<>(stacks);
        excludeSmallest.remove(getSmallestDisk());

        Stack<Integer> stk1 = excludeSmallest.get(0);
        Stack<Integer> stk2 = excludeSmallest.get(1);

        if (stk1.empty() && stk2.isEmpty()) return;
        if (stk1.empty())
            stk1.push(stk2.pop());
            else if (stk2.isEmpty())
                     stk2.push(stk1.pop());
            else if (stk1.peek() < stk2.peek())
                     stk2.push(stk1.pop());
            else     stk1.push(stk2.pop());
    }

    
    public static Stack<Integer> getSmallestDisk() { // get smallest from the stack 
        Stack<Integer> smallest = null;
        for (Stack<Integer> stack : stacks) {
            if (smallest == null) smallest = stack;
            if (stack.isEmpty()) continue;
            try {
                if (smallest.isEmpty())
                    smallest = stack;
                else if (stack.peek() < smallest.peek())
                    smallest = stack;
            } catch (EmptyStackException ignore) {
            }
        }
        return smallest;
    }

       public static void moveSmallestPart() { 
        Stack<Integer> smallest = getSmallestDisk();

        int size = stacks.size();
        int index = stacks.indexOf(smallest);
        int findIndex = ((size & 1) == 1) ? 1 : -1;
        index += findIndex;
        if (index < 0)
            index = size - 1;
        if (index == size)
            index = 0; 

        // Move smallest to the top of Stack 
        stacks.get(index).push(smallest.pop());
    }

   
}
