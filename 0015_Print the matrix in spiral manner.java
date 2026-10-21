import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int up = 0, down = n - 1;
        int left = 0, right = m - 1;
        while (answer.size() < n * m) {
            // Top row: left → right
            for (int j = left; j <= right && answer.size() < n * m; j++) {
                answer.add(matrix[up][j]);
            }
            // Right column: up+1 → down-1
            for (int i = up + 1; i <= down - 1 && answer.size() < n * m; i++) {
                answer.add(matrix[i][right]);
            }
            // Bottom row: right → left
            for (int j = right; j >= left && answer.size() < n * m; j--) {
                answer.add(matrix[down][j]);
            }
            // Left column: down-1 → up+1
            for (int i = down - 1; i >= up + 1 && answer.size() < n * m; i--) {
                answer.add(matrix[i][left]);
            }
            // Layer complete → shrink boundaries
            left++;
            right--;
            up++;
            down--;
        }
        return answer;
    }
}
