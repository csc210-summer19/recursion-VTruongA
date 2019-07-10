import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Vincent Truong
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    if(k == 1)
    	return n;
    if (n == k)
    	return 1;
    return combinations(n-1, k-1) + combinations(n-1, k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
    return intWithCommasHelper(String.valueOf(n),1);
  }


private String intWithCommasHelper(String n,int i) {
	if (n.length() == 0)
		return "";
	else if (i == 4)
		return intWithCommasHelper(n.substring(0,n.length()),1) + ",";
	else
		return intWithCommasHelper(n.substring(0,n.length()-1),i+1) + n.charAt(n.length()-1);
}


// Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    if (index >= (len/2))
    	;
    else {
    	int temp = x[len-index-1];
    	x[len-index-1] = x[index];
    	x[index] = temp;
    	reverseArray(x, index + 1, len);
    }
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
    return arrayRangeHelper(a,a[0],a[0]);
  }

  private int arrayRangeHelper(int[] a, int max, int min) {
	if (a.length == 0)
		return max - min;
	else {
		if (a[0]>max)
			max = a[0];
		if (a[0]<min)
			min = a[0];
		return arrayRangeHelper(Arrays.copyOfRange(a,1, a.length),max,min);
	}		
}


// Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
    if (nums.length <= 1)
    	return true;
    else {
    	if (nums[0]>nums[1])
    		return false;
    	return isSorted(Arrays.copyOfRange(nums, 1, nums.length));
    }
  }

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
	 if (strs.length == 0)
		 return false;
     else {
         if (strs[0].equals(search))
        	 return true;
    	 return found(search, Arrays.copyOfRange(strs, 1, strs.length));
     }
  }
}
