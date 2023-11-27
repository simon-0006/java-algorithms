package CodeExpert;

class TreeNode {
	  public int key;
	  public int value;
	  
	  // costum attributes
	  public int gVL; // greatest Value Left (- Right)
	  public int gVR;
	  
	  public TreeNode parent;
	  public TreeNode left;
	  public TreeNode right;

	  TreeNode(int key, int value) {
	    this.key = key;
	    this.value = value;
	    this.parent = null;
	    this.left = null;
	    this.right = null;
	    
	    // costumed
	    this.gVL = Integer.MAX_VALUE+1;
	    this.gVR = Integer.MAX_VALUE+1;
	  }
	}

public class TicketShop {
	
	
	public static void main(String[] args) {
	    // Uncomment the following two lines if you want to read from a file.
		int D = 20;
	    int k = 0;
	    int n = 9;
	    int[] A = new int[] {2, 4 ,2 ,3 ,1 ,3 ,3 ,4 ,3};
	    
	    System.out.println(minTicket(D, k, n, A));
	    
	    // Uncomment this line if you want to read from a file
	    // In.close();
	  }
	  
	  public static int minTicket(int D, int k, int n, int[] A) {
	    int[][][] dpTable = new int[k+1][n+1][D+1]; // dpTable[k][n][D]
	    
	    dpFiller(dpTable, A);
	    
	    return dpTable[k][n][D];
	  }
	  
	// Right test
	  private TreeNode rightTest(TreeNode current, int x) {
	    TreeNode hopBack = current;
	    System.out.println(current.value + " " + current.key);
	    // Laufe Rechts bis nicht mehr geht
	    while(current.gVR > current.gVL && current.right.key <= x) {
	      current = current.right;
	      
	      // hop Back actualize
	      if(Math.max(current.gVL,current.value) >= 
	         Math.max(hopBack.gVL,hopBack.value)) hopBack = current;
	         
	      
	    }
	    // hop Back actualize
	    if(Math.max(current.gVL, current.value) >= 
	       Math.max(hopBack.gVL, hopBack.value) ) hopBack = current;
	    
	    // rekursiv den entry bestimmen
	    if(current.key > x) {
	      if(current.left != null) return rightTest(current.left, x);
	      else return null;
	    }
	    
	    return hopBack;
	  }
	  
	  static void dpFiller(int[][][] dpTable, int[] A) {
	    
	    // DEBUG
	    System.out.print(0 + " ");
	    for(int i = 0; i < dpTable[0][0].length; i++){
	      System.out.print(i%10 + " ");}
	      
	    for(int k = 0; k < dpTable.length; k++){
	      System.out.println("\n");
	      for(int n = 0; n < dpTable[k].length; n++) {
	        for(int d = 0; d < dpTable[k][n].length; d++) {
	          
	          // Base Case n = 0
	          if(n == 0) dpTable[k][n][d] = 0;
	          else{
	            // Fall 1: n = d
	            int same = (d == A[n-1]) ? 1 : 0;
	            
	            // Fall 2: d bei n-1
	            int last = dpTable[k][n-1][d];
	            
	            // Fall 3: Zusammensetzbar aus d-n
	            int before = 0;
	            
	            // behind index
	            // value is reachable
	            if(d - A[n-1] > 0 &&
	               k > 0 &&
	               dpTable[k-1][n][d - A[n-1]] > 0) {
	              
	              before = dpTable[k-1][n][d - A[n-1]];
	            }
	            else if(d - A[n-1] > 0 &&
	               k == 0 &&
	               dpTable[k][n-1][d - A[n-1]] > 0) before = dpTable[k][n-1][d - A[n-1]] + 1;
	            
	            // Minimum grösser als null:
	            if(same == 1) dpTable[k][n][d] = 1;
	            
	            else if(last != 0 && before != 0) dpTable[k][n][d] = Math.min(last,before);
	              
	            else if(last != 0)   dpTable[k][n][d] = last;
	            else if(before != 0) dpTable[k][n][d] = before;
	            
	            else dpTable[k][n][d] = 0;
	            
	            // DEBUG
	            //System.out.println("dpTable[" + n + "][" + d + "] = " + dpTable[k][n][d]);
	            System.out.print(dpTable[k][n][d] + " ");
	          
	            
	          }
	          
	        }
	        if(n<A.length) System.out.print("\n" + A[n] + " ");
	      }
	    }
	    
	  }
	  
	  
	// Right test
//	  private TreeNode RightTest(TreeNode current, int x) {
//	    TreeNode hopBack = current;
//	    // Laufe Rechts bis nicht mehr geht
//	    
//	    while(current.gVR > current.gVL) {
//	      // geh weiter nach rechts
//	      if(current.right.key <= x) current = current.right;
//	      
//	      // such weiter im linken chiltree
//	      else {
//	        if(current.key <= x){
//	          if(current.right.left != null) {
//	            current = current.right.left;
//	          } else break;
//	        } else break;
//	      }
//	      
//	      // hop Back actualize
//	      if(Math.max(current.gVL,current.value) >= 
//	         Math.max(hopBack.gVL,hopBack.value)) hopBack = current;
//	      
//	    }
//	    
//	    // rekursiv den entry bestimmen
//	    if(hopBack.key > x) {
//	      if(hopBack.left != null) return rightTest(hopBack.left, x);
//	      else return null;
//	    }
//	  }

}
