class Solution2 {

    private int R, C;
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid){

        if(grid == null) return 0;
        R = grid.length;
        if(R == 0) return 0;

        C = grid[0].length;
        if(C == 0) return 0;

        this.grid = grid;

        int res = 0;
        for(int i = 0; i < R; i ++)
            for(int j = 0; j < C; j ++)
                if(grid[i][j] == 1)
                    res = Math.max(res, dfs(i, j));
        return res;
    }

    private int dfs(int x, int y){

        if(x < 0 || x >= R || y < 0 || y >= C || grid[x][y] == 0) return 0;

        grid[x][y] = 0;
        int res = 1;
        res += dfs(x - 1, y);
        res += dfs(x, y + 1);
        res += dfs(x + 1, y);
        res += dfs(x, y - 1);
        return res;
    }
}
