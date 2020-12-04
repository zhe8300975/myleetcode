package medium.day20;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。

public class LeetCode200 {
    public static void main(String[] args) {


//        char[][] land = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] land = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};

        System.out.println(numIslands(land));
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        for (int x = 0; x < rowSize; x++) {
            for (int y = 0; y < columnSize; y++) {
                if (grid[x][y] == '1') {
                    result++;
                    dealLands(grid, x, y);
                }
            }
        }
        return result;
    }

    public static void dealLands(char[][] grid, int x, int y) {
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        grid[x][y] = '0';
        if (x > 0 && grid[x - 1][y] == '1') {
            dealLands(grid, x - 1, y);
        }
        if (x < rowSize - 1 && grid[x + 1][y] == '1') {
            dealLands(grid, x + 1, y);
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            dealLands(grid, x, y - 1);
        }
        if (y < columnSize - 1 && grid[x][y + 1] == '1') {
            dealLands(grid, x, y + 1);
        }
    }
}
