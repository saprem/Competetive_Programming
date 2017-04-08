Q1.
Basic right and down
Pseudo code:

We can recursively compute grid[i][j] using below 
formula and finally return grid[R-1][C-1]
// Initializing the leftmost column
  for i=0:R
        if (maze[i][0] == 0)
            maze[i][0] = 1;
        // If we encounter a blocked cell in leftmost
        // row, there is no way of visiting any cell
        // directly below it.
        else
            break;
    
  // If current cell is a blockage
  if (maze[i][j] == -1)
      maze[i][j] = -1; //  Do not change

  // If we can reach maze[i][j] from maze[i-1][j]
  // then increment count.
  else if (maze[i-1][j] > 0)
      maze[i][j] = (maze[i][j] + maze[i-1][j]);

  // If we can reach maze[i][j] from maze[i][j-1]
  // then increment count.
  else if (maze[i][j-1] > 0)
      maze[i][j] = (maze[i][j] + maze[i][j-1]);

//while reurn check first and last cell 

Q2.
Can move in any direction but do not reapeat same cell
for any (n)x(n) matrix

int arr [100 + 1][100 + 1];
int dirc [][2] = { {1 , 0}, {-1 , 0}, {0 , 1}, {0 , -1} };
int ans = 0;
boolean vis [100 + 1][100 + 1];

void rec(int x, int y){
	
    if(x == n - 1 && y == n - 1){     // base case
        ans++;                        // increase the number of ways
        return;
    }

    vis[x][y] = true;

    for(int i = 0; i < 4; i++){

        int dx = x + dirc[i][0];                                // new transitions
        int dy = y + dirc[i][1];

        if(dx < 0 || dx >= n || dy < 0 || dy >= n) continue;    // outside of the board
        if(vis[dx][dy] || arr[dx][dy] == 1) continue;           // check for invalid or visited positions

        rec(dx, dy);
        vis[dx][dy] = false;            // back track
    }
}
