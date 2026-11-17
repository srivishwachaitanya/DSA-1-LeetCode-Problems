class Solution {
    private int idx;

    public String decodeString(String s) {
        idx = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                String inner = decode(s);
                while (count > 0) {
                    sb.append(inner);
                    count--;
                }
            } else if (c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
