class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r - c + n
        boolean[] diag2 = new boolean[2 * n]; // r + c
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, n, board, cols, diag1, diag2, res);
        return res;
    }

    private void backtrack(
        int r, int n, char[][] board,
        boolean[] cols, boolean[] diag1, boolean[] diag2,
        List<List<String>> res
    ) {
        if (r == n) {
            List<String> snapshot = new ArrayList<>();
            for (char[] row : board) {
                snapshot.add(new String(row));
            }
            res.add(snapshot);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r - c + n;
            int d2 = r + c;
            if (cols[c] || diag1[d1] || diag2[d2]) {
                continue;
            }
            cols[c] = diag1[d1] = diag2[d2] = true;
            board[r][c] = 'Q';

            backtrack(r + 1, n, board, cols, diag1, diag2, res);

            board[r][c] = '.';
            cols[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}
