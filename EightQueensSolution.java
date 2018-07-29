import java.util.ArrayList;
/**
 * This class uses backtracking to find the solutions to the 8 Queens Problem.
 * @author tarcan gul
 *
 */
public class EightQueensSolution {
	
	public int size; //Size of the board
	ArrayList<Solution> solutions = new ArrayList<Solution>(); 
	boolean used[]; //This array will track which rows are already used.
	int solutionArray[];//This will keep which row the queen is in every column.
	int solutionNumber = 0; //number of solutions
	
	public EightQueensSolution(int s)
	{
		size = s;
		used = new boolean[s]; 
		solutionArray = new int[s];
		
		for(int i = 0; i < used.length; i++)
		{
			used[i] = false;
		}
		solve();
	}
	
	public ArrayList<Solution> getSolutions()
	{
		return solutions;
	}
	
	
	public int getSolutionNumber()
	{
		return solutionNumber; 
	}
	
	public void solve()
	{
		solveRecursively(0);
	}
	
	
	private void solveRecursively(int location)
	{
		if(location == size)//we reached to the end of the board, the solution is acceptable.
		{
			Solution s = convertArrayToSolution(solutionArray);
			solutions.add(s);
			solutionNumber++;
		}
		
		for(int i = 0; i < size; i++) //Trying columns.
		{
			if(!used[i])
			{
				if(notConflicting(location, i))
				{
					solutionArray[location] = i;
					used[i] = true;
					solveRecursively(location+1); //Going one step ahead.
					used[i] = false; //Backtracking
				}
			}
				
		}
			
			
		
	}
	
	private boolean notConflicting(int loc, int r)
	{
		for(int k = 0; k < loc;k++)
		{
			if(Math.abs(solutionArray[k] - r) == Math.abs(k-loc))//Checking the diagonals.
			{
				return false;
			}
		}
		return true;
	}
	
	private Solution convertArrayToSolution(int[] arr)
	{
		Solution s = new Solution(arr.length);
		for(int i = 0; i < arr.length; i++)
		{
			s.putQueen(arr[i], i);
		}
		
		return s;
	}

}
