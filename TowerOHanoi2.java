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