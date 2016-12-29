/* PROBLEM 3
Dominator - Find an index of an array such that its value occurs at more than half of indices in the
array.
A zero-indexed array A consisting of N integers is given. The d ominator of array A is the value
that occurs in more than half of the elements of A.
For example, consider array A such that
A[0] = 3 A[1] = 4 A[2] = 3
A[3] = 2 A[4] = 3 A[5] = -1
A[6] = 3 A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with
indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
Write a function
class Solution { public int solution(int[] A); }

that, given a zero-indexed array A consisting of N integers, returns index of any element of array
A in which the dominator of A occurs. The function should return −1 if array A does not have a
dominator.
Assume that:
● N is an integer within the range [0..100,000];
● each element of array A is an integer within the range
[−2,147,483,648..2,147,483,647].
For example, given array A such that
A[0] = 3 A[1] = 4 A[2] = 3
A[3] = 2 A[4] = 3 A[5] = -1
A[6] = 3 A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.
Complexity:
● expected worst-case time complexity is O(N);
● expected worst-case space complexity is O(1), beyond input storage (not counting
the storage required for input arguments).
Elements of input arrays can be modified.
*/
/* Solution : 

We have to write a function
class Solution { public int solution(int[] A); }
Given a zero-indexed array A consisting of N integers, returns index of any element of array
A in which the dominator of A occurs. The function should return −1 if array A does not have a
dominator.

*/
/* (Using Moore’s Voting Algorithm)
This is a two step process.
1. Get an element occurring most of the time in the array. This phase will make sure that if there is a majority element then it will return that only.
2. Check if the element obtained from above step is majority element.

Case 1. Finding a Candidate:
The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.

findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]
First Phase algorithm gives us a candidate element. In second phase we need to check if the candidate is really a majority element. Second phase is simple and can be easily done in O(n). We just need to check if count of the candidate element is greater than n/2.
Example:
A[] = 2, 2, 3, 5, 2, 2, 6
Initialize:
maj_index = 0, count = 1 –> candidate ‘2?
2, 2, 3, 5, 2, 2, 6
Same as a[maj_index] => count = 2
2, 2, 3, 5, 2, 2, 6
Different from a[maj_index] => count = 1
2, 2, 3, 5, 2, 2, 6
Different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
2, 2, 3, 5, 2, 2, 6
Different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 2 => maj_index = 4
2, 2, 3, 5, 2, 2, 6
Same as a[maj_index] => count = 2
2, 2, 3, 5, 2, 2, 6
Different from a[maj_index] => count = 1
Finally candidate for majority element is 2.
First step uses Moore’s Voting Algorithm to get a candidate for majority element.

Case 2. Check if the element obtained in step 1 is majority
printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "NONE"
*/

import java.util.Scanner;
public class DominatorinArray3 {
  
  public int solution(int[] A) {
    //input integer array 
	Scanner s=new Scanner(System.in);
    System.out.println(" Enter number of elements to insert in an array of size N less than 100000 in Size ");
    int n=s.nextInt();
    int arr[]=new int[n];
    System.out.println("\n Enter elements of the array to find Dominator : ");
    for(int i=0;i<n;i++){//for reading array input
        arr[i]=s.nextInt();
    }
    for(int i: arr){ //for printing stored array initially 
        System.out.print("\n Input numbers are "+i);
    }
       // write your code in Java SE 
        int sizecount = 0; int val = 0;
        //We calculate the value of the most value of appear from the array
        //We keep that in the value. 
        for (int i = 0; i < A.length; i++) {
            if(sizecount == 0) { sizecount++; val = A[i];
               } 
			else {
				if (val != A[i]) { sizecount -=1;  } 
	      		else { sizecount++;  }
                 }
        }
        int candidate = -1;
        if(sizecount > 0) {
            candidate = val;
        }
        int index = -1;
        int count = 0;
        // step to determine the most element of the array is more than half of array length or not. 
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) { 
			count++; index = i;
            }
        }
        
        //if it's not more than half we return -1
        
        if(count > (A.length/2)) {
            return index;  //otherwise we return the index... 
        } else {
            return -1;  // Here we don't return the value itself because no Dominatr is found in Array ..
        }
    }
}
