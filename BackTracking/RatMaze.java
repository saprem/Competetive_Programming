Q1. Basic
 A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
   
If destination is reached
    print the solution matrix
Else
   a) Mark current cell in solution matrix as 1. 
   b) Move forward in horizontal direction and recursively check if this 
       move leads to a solution. 
   c) If the move chosen in the above step doesn't lead to a solution
       then move down and check if  this move leads to a solution. 
   d) If none of the above solutions work then unmark this cell as 0 
       (BACKTRACK) and return false.
         
Code: 
-----
	
boolean isSafe(int maze[][], int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 0);
}

boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
		
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y) == true) {
			sol[x][y] = 1;
			/* Move forward in x direction */
			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;
			/*
			 * If moving in x direction doesn't give solution then Move down in
			 * y direction
			 */
			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;

			/*
			 * If none of the above movements work then BACKTRACK: unmark x,y as
			 * part of solution path
			 */
			sol[x][y] = 0;
			return false;
		}
		return false;
}
         
