// Arup Guha 
// 2/26/08
// Solves the Eight Queens problem using backtracking.
// Ported to Java on 7/25/2010
//Commented and updated by Tarcan Gül

import java.util.*;

public class SolutionAlgorithm {

 private int[] perm;//Integer array
 private boolean[] used;//Boolean array                                              
 private int sol_number;//Total number of solutions
 private int size;//size of the chess board
 
 private ArrayList<Solution> s_set;//Includes all the solutions.
 
 
 // Creates an SolutionAlgorithm object for an nxn board.
 public SolutionAlgorithm(int n) {
  
  	 
  perm = new int[n];//Integer array with n elements.
  used = new boolean[n];//Boolean array with n elements. This is to see the used rows, since every queen should be in different row.
  sol_number = 0;//Number of solutions so far.
  s_set = new ArrayList<Solution>(); //the solution set arraylist which will keep all the solutions.
  size = n;//Instance variable size gets a value.
  
  for (int i=0; i<n; i++) {
   perm[i] = -1;//Filling every member of perm array with -1.
   used[i] = false;//Filling every member of used boolean array with false.
  }
  solveIt();//Solves the problem and gives us the solutions.
  setSolutions();//Takes all the solutions and put them into a set.
  s_set.remove(s_set.size()-1);//Removing the last entry of the solution set because it is wrong.
 }

 // Solves the 8-Queens problem for this object. This is just a 
 // wrapper function.
 public void solveIt() {
          
      // Call the recursive function.
      solveItRec(0);
 }

 // Pre-condition: perm stores a permutation of queens from index 0 to location-1
 //                that is valid for a set of location number of non-conflicting
 //                queens. location represents the column we are placing the next
 //                queen, and usedList keeps track of the rows in which queens
 //                have already been placed.
 public void solveItRec(int location) {
     
     int i;//Used for iterating through a permutation.
    
     // We've found a solution to the problem, so print it!
     if (location == perm.length) {
         setSolutions();
         sol_number++;
     }
    
     // Loop through possible locations for the next queen to place.
     for (i=0; i<perm.length; i++) {
        
         // Only try this row if it hasn't already been used.
         if (used[i] == false) {
            
             // We can actually place this particular queen without conflict!                     
             if (!conflict(location, i)) {
                                
                 // Place the new queen!                
                 perm[location] = i;
                
                 // We've used this row now, so mark that.
                 used[i] = true;
                
                 // Recursively solve this board.
                 solveItRec(location+1);
                
                 // Unselect this square, so that we can continue trying to
                 // fill it with the next possible choice.
                 used[i] = false;
             }                         
                                 
         }    
     }
     
 } 

 private boolean conflict(int location, int row) {
    
     int i;//Used to iterate
    
     // See if the grid spot (location, row) shares a diagonal with any of
     // the previously placed queens.
     for (i=0; i<location; i++)
    
         // Diagonals have equal distance in the x and y axes.
         if (Math.abs(location - i) == Math.abs(perm[i] - row))
             return true;
            
     // No conflict, so we could place a queen there.
     return false;    
 }

 
 // Gets the permutations and update solution objects then adding solution objects to the solution set.
 public void setSolutions() {
     
     int i,j;
     Solution s = new Solution(size);//Creating a new solution object.
     
      // Loop through each row.
      for (i=0; i<perm.length; i++) {
         
          // Go through each column in row i.
          for (j=0; j<perm.length; j++) {
         
              // This means that the queen in column j resides in row i.
              if (perm[j] == i)     
                 s.putQueen(i, j);//Puts queen on a specified square.
                 
   
            
          }
         
      }
      s_set.add(s);//Adding solution to the solution set.
 }
 
 
 public ArrayList<Solution> getSolutions()//Accessor method for solution set.
 {
	 return s_set;//Returns the solution set.
 }

 public int getSolutionNumber() //Accessor method for sol_number
 {
	 return sol_number;//Returns the number of solutions.
 }
}