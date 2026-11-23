class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int openCount, int closeCount, int n, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (openCount < n) {
            path.append('(');
            backtrack(openCount + 1, closeCount, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (closeCount < openCount) {
            path.append(')');
            backtrack(openCount, closeCount + 1, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
