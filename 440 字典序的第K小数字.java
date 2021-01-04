class Solution {
    public int findKthNumber(int n, int k) {
        int pos = 1; 
        int prefix = 1;
        while (pos < k) {
            int tmp = count(prefix, n);
            if (pos + tmp > k) {
                prefix *= 10;
                pos++;
            } else {
                prefix++;
                pos += tmp;
            }
        }
        return prefix;
    }

    private int count(int prefix, int n) {
        long cur = prefix;
        long next = cur+1;
        int count = 0;
        while (cur <= n){
            count += Math.min(n+1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
