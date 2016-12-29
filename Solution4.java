/*Ladder - Count the number of different ways of climbing to the top of a ladder
You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you
can ascend by one or two rungs. More precisely:
● with your first step you can stand on rung 1 or 2,
● if you are on rung K, you can move to rungs K + 1 or K + 2,
● finally you have to stand on rung N.
Your task is to count the number of different ways of climbing to the top of the ladder.
For example, given N = 4, you have five different ways of climbing, ascending by:
● 1, 1, 1 and 1 rung,
● 1, 1 and 2 rungs,
● 1, 2 and 1 rung,
● 2, 1 and 1 rungs, and
● 2 and 2 rungs.
Given N = 5, you have eight different ways of climbing, ascending by:
● 1, 1, 1, 1 and 1 rung,
● 1, 1, 1 and 2 rungs,
● 1, 1, 2 and 1 rung,
● 1, 2, 1 and 1 rung,
● 1, 2 and 2 rungs,
● 2, 1, 1 and 1 rungs,
● 2, 1 and 2 rungs, and
● 2, 2 and 1 rung.
The number of different ways can be very large, so it is sufficient to return the result modulo 2 P , for a given
integer P.
Write a function:
class Solution { public int[] solution(int[] A, int[] B); }
that, given two non-empty zero-indexed arrays A and B of L integers, returns an array consisting of L
integers specifying the consecutive answers; position I should contain the number of different ways of
climbing the ladder with A[I] rungs modulo 2 B[I] .
For example, given L = 5 and:
A[0] = 4 B[0] = 3
A[1] = 4 B[1] = 2
A[2] = 5 B[2] = 4
A[3] = 5 B[3] = 3
A[4] = 1 B[4] = 1
the function should return the sequence [5, 1, 8, 0, 1], as explained above.
Assume that:
● L is an integer within the range [1..30,000];
● each element of array A is an integer within the range [1..L];
● each element of array B is an integer within the range [1..30].
Complexity:
● expected worst-case time complexity is O(L);
● expected worst-case space complexity is O(L), beyond input storage (not counting the storage
required for input arguments).
Elements of input arrays can be modified.
*/

/* Solution : 
A java program to count number of ways to reach n'th stair when
A person can climb 1 or 2 stairs at a time
*/
import java.util.Scanner;
class Solution4
{
    // A recursive function used by countWays
    static int solution(int A, int B)
    {
        if (A <= 1)
            return A;
        int res = 0;
        for (int i = 1; i<=B && i<=A; i++)
            res += solution(A-i, B);
		
        return res;
    }
    // Returns number of ways to reach s'th stair
    static int countWays(int s, int B)
    {
        return solution(s+1, B);
    }
 
    /* Driver program to test above function */
    public static void main (String args[])
    {  Scanner sc = new Scanner(System.in);
       System.out.print("Enter the number of Stairs in the ladder : ");
       int s = sc.nextInt();
        int B = 2; int A = 1;
          System.out.println("Number of ways = "+ countWays(s,B));
    } 
}
