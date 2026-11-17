class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        @SuppressWarnings("unchecked")
        List<Integer>[][] memo = new List[n][n];
        return solve(expression, 0, n - 1, memo);
    }

    private List<Integer> solve(String expr, int start, int end, List<Integer>[][] memo) {
        if (memo[start][end] != null) return memo[start][end];
        List<Integer> res = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            char op = expr.charAt(i);
            if (op == '+' || op == '-' || op == '*') {
                List<Integer> left = solve(expr, start, i - 1, memo);
                List<Integer> right = solve(expr, i + 1, end, memo);
                for (int l : left) {
                    for (int r : right) {
                        if (op == '+') res.add(l + r);
                        else if (op == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }
        }

        if (res.isEmpty()) {
            int num = 0;
            for (int i = start; i <= end; i++) {
                num = num * 10 + (expr.charAt(i) - '0');
            }
            res.add(num);
        }
        return memo[start][end] = res;
    }
}
