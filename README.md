# 8 Queens Problem
## Eight Queens Problem Documentation

***Aim***: Aim of the program is to be an interactive program where the user can see every individual solution in any desired square.

### Classes included:
```
Solution: Object that holds a 2D boolean solution.
SolutionAlgrorithm: The class that solves the Queens problem mathematically and gives us Solution objects.
BoardComponent:  Where we draw the board and put the queens.
BoardPanel: Where we mix the buttons with the component.
SolutionViewer: The test class which puts the panel to the frame.
SquareButton: Individual buttons of the shape squares on the board. Interactive.
TButton:  Navigation buttons.  
```
#### BoardPanel extends JPanel
```
public BoardPanel() – Only sets the layout and put the BoardComponent.
```
#### BoardComponent extends JComponent
```
public BoardComponent(JPanel p ) –Creating and adding functionality to the forward and back navigation buttons.
public void paintComponent(Graphics g) -  Adds the navigation buttons, activates drawButtonChessBoard(SIZE), gets the solution and shows the selected solution onto the screen, also draws the instructions on the frame.
public void drawButtonsChessBoard(int size) – Puts buttons as a shape of a size*size chessboard.
public void putQueen(int a, int b, Graphics2D g2) – Puts a queen image into a specified location on a chessboard. 
public void setSolution(Solution s,Graphics2D g2) – Puts the specified solution s to the screen.
```
#### EightQueensSolution
```
public EightQueensSolution (int n) – Calculates and gives an arraylist of solutions for a specified n*n size chessboard.
public void solve() – Wrapper function that solves the queens problem.
public void solveRecursively(int location) – Finding the solutions of queens problem by checking every possibility(using backtracking). 
private boolean notConflicting(int location, int row) – Checks whether a position is not threatened by previously added queens.
public void convertArrayToSolution()– Gets an one dimensional array and converts in to a 2D boolean solution.
public void getSolutionNumber()– Print the number of solutions.
public ArrayList<Solution> getSolutions() – Returns the solution set.
```
#### Solution
```
public Solution(int size) – Fills an empty 2D boolean with false.
public boolean[][] getSolution() – Returns the solution.
public int getSize() – Returning the size.
public void putQueen(int x, int y) – Put queen to the desired coordinates in the 2D boolean.
```
#### TButton extends JButton
```
public TButton(int x, int y,int w,int h,String text) – Constructs a new button with location, size and title.
```
#### SquareButton extends JButton
```
public SquareButton(int row, int column) – Constructs a button in a specified row and column, put them in a spesific position.
public int getRow() – Returns row number.
public int getColumn() – Returns column number.
```
