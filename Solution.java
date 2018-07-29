/**
 * Object that stores one boolean[][] answer for Queens Problem.
 * @author tarcan gül
 *
 */

public class Solution 
{
	private boolean[][] solution;//A solution to the queen problem declared in 2D boolean array.
	private int size;//one dimension of the board.
	
	/**
	 * Creating a new solution and setting every part false, not putting thw queen yet.
	 * @param size size of the board, thus the solution of boolean 2D array.
	 */
	public Solution(int size)
	{
		solution = new boolean[size][size];//Creating a new 2D boolean array.
		//Setting every part of the boolean array "false".
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size;j++)
			{
				solution[i][j] = false;//Setting every element false.
			}
		}
		this.size = size;//Setting up the instance variable.
	}
	

	//Accessor method for solution 2D array. 
	public boolean[][] getSolution()
	{
		return solution;//Returns the solution itself.
	}
	//Accessor method for size.
	public int getSize()
	{
		return size;//returns size
	}
	/**
	 * Puts queen(setting it true) to a desired row and column number.
	 * @param x : row number
	 * @param y : column number
	 */
	public void putQueen(int x, int y)
	{
		solution[x][y] = true;//Setting the desired spot true, which will trigger to put queen.
	}
	
	
}
