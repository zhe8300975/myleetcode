package medium.day24;

public class LeetCode240 {
    public static void main(String[] args) {

//        11
        int[][] m = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}};
//        int[][] m = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(m, 11));
    }
//
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int row = matrix.length;
//        int column = matrix[0].length;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<column;j++){
//                if(matrix[i][j]==target){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int x = row - 1, y = 0;
        while (x >= 0 && y < column) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            }
        }
        return false;
    }
}
