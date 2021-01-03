class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        StringBuilder rows[] = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++){
            rows[i] = new StringBuilder();
        }
        int direction = 1; // go down for 1, go up for -1
        int idx = 0;
        for (char c : s.toCharArray()){
            rows[idx].append(c);
            idx += direction;
            if (idx == 0 || idx == numRows - 1) {
                direction = -direction;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < rows.length; j++){
            res.append(rows[j]);
        }
        return res.toString();
    }
}
