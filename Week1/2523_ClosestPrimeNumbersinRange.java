class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right - left < 1) return new int[]{-1, -1};
        if (left <= 2 && right >= 3) return new int[]{2, 3};

        int prev = -1;
        int bestA = -1;
        int bestB = -1;
        int minDiff = Integer.MAX_VALUE;
        int start = left <= 3 ? 3 : (left | 1);
        for (int num = start; num <= right; num += 2) {
            if (isPrime(num)) {
                if (prev != -1) {
                    int diff = num - prev;
                    if (diff == 2) {
                        return new int[]{prev, num};
                    }
                    if (diff < minDiff) {
                        minDiff = diff;
                        bestA = prev;
                        bestB = num;
                    }
                }
                prev = num;
            }
        }
        return bestA == -1 ? new int[]{-1, -1} : new int[]{bestA, bestB};
    }
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n <= 3) return true;
        if ((n & 1) == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
