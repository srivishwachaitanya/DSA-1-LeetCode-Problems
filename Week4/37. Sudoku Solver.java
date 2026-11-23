class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        List<int[]> empty = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    empty.add(new int[]{r, c});
                } else {
                    int d = val - '0';
                    rows[r][d] = true;
                    cols[c][d] = true;
                    boxes[(r / 3) * 3 + (c / 3)][d] = true;
                }
            }
        }

        backtrack(0, board, empty, rows, cols, boxes);
    }

    private boolean backtrack(
        int idx, char[][] board, List<int[]> empty,
        boolean[][] rows, boolean[][] cols, boolean[][] boxes
    ) {
        if (idx == empty.size()) {
            return true;
        }

        int r = empty.get(idx)[0];
        int c = empty.get(idx)[1];
        int b = (r / 3) * 3 + (c / 3);

        for (int d = 1; d <= 9; d++) {
            if (!rows[r][d] && !cols[c][d] && !boxes[b][d]) {
                board[r][c] = (char) ('0' + d);
                rows[r][d] = cols[c][d] = boxes[b][d] = true;

                if (backtrack(idx + 1, board, empty, rows, cols, boxes)) {
                    return true;
                }

                board[r][c] = '.';
                rows[r][d] = cols[c][d] = boxes[b][d] = false;
            }
        }
        return false;
    }
}
