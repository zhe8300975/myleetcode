package medium.day15;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class LeetCode79 {
    public static void main(String[] args) {
//        char[][] num = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] num = {{'A'}};
        System.out.println(exist(num, "A"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (check(board, new boolean[board.length][board[0].length], row, column, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
        if (word.charAt(index) != board[x][y]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        } else {
            visited[x][y] = true;
            int row = board.length;
            int column = board[0].length;
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                boolean check = check(board, visited, x - 1, y, index + 1, word);
                if (check) return check;
            }
            if (x + 1 <= row - 1 && !visited[x + 1][y]) {
                boolean check = check(board, visited, x + 1, y, index + 1, word);
                if (check) return check;
            }
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                boolean check = check(board, visited, x, y - 1, index + 1, word);
                if (check) return check;
            }
            if (y + 1 <= column - 1 && !visited[x][y + 1]) {
                boolean check = check(board, visited, x, y + 1, index + 1, word);
                if (check) return check;
            }
            visited[x][y] = false;
            return false;
        }
    }

//    public static boolean check(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
//        if (index == word.length() - 1) {
//            return word.charAt(index) == board[x][y];
//        } else {
//            boolean result = false;
//            if (word.charAt(index) == board[x][y]) {
//                visited[x][y] = true;
//                int row = board.length;
//                int column = board[0].length;
//                if (x - 1 >= 0 && !visited[x - 1][y]) {
//                    result = result || check(board, visited, x - 1, y, index + 1, word);
//                }
//                if (!result && x + 1 <= row - 1 && !visited[x + 1][y]) {
//                    result = result | check(board, visited, x + 1, y, index + 1, word);
//                }
//                if (!result && y - 1 >= 0 && !visited[x][y - 1]) {
//                    result = result | check(board, visited, x, y - 1, index + 1, word);
//                }
//                if (!result && y + 1 <= column - 1 && !visited[x][y + 1]) {
//                    result = result | check(board, visited, x, y + 1, index + 1, word);
//                }
//                visited[x][y] = false;
//            }
//            return result;
//        }
//    }
}
