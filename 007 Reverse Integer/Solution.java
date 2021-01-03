class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res*10/10 != res) return 0; // overflow
            res = res*10 + x%10;
            x /= 10;
        }
        return res;
    }
}
