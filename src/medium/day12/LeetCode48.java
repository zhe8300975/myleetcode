package medium.day12;

import java.util.Arrays;

//给定一个 n × n 的二维矩阵表示一个图像。
//
// 将图像顺时针旋转 90 度。
//
// 说明：
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
// 示例 1:
//
// 给定 matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//
//
// 示例 2:
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
public class LeetCode48 {


    public static void main(String[] args) {
        int[] row1 = new int[]{1, 2, 3, 4};
        int[] row2 = new int[]{4, 5, 6, 7};
        int[] row3 = new int[]{8, 9, 10, 11};
        int[] row4 = new int[]{12, 13, 14, 15};
        int[][] matrix = new int[][]{row1, row2, row3, row4};
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    //    public static void rotate(int[][] matrix) {
//        int start = 0;
//        int end = matrix.length - 1;
//        while (end > start) {
//            int var;
//            for (int i = 0; i < end-start; i++) {
//                var = matrix[start][i+start];
//                matrix[start][i+start] = matrix[end - i][start];
//                matrix[end - i][start] = matrix[end][end - i];
//                matrix[end][end - i] = matrix[i+start][end];
//                matrix[i+start][end] = var;
//            }
//            start++;
//            end--;
//        }
//    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = swap;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int swap = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = swap;
            }
        }
    }


}
