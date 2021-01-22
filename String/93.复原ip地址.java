import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s.length()<4) return res;
        int [] ip = new int[4];
        helper(res, s, 0, ip, 0);
        return res;
    }

    void helper(List<String> res, String s, int idx, int[] ip,  int segment){
        if(segment == 4 && idx == s.length() ){
            res.add(ip[0] + "." + ip[1] + "."+ ip[2] + "." + ip[3]);
            return;
        } else if(segment == 4 || idx == s.length() ){
            return;
        }
        
        for(int i = 1; i <= 3 && idx + i <= s.length() ; i++){
            int val = Integer.parseInt(s.substring(idx, idx + i));
            if(val > 255 || i >= 2  && s.charAt(idx) == '0') 
                break; 
                
            ip[segment] = val;
            helper(res, s, idx + i, ip, segment + 1);
        }
    }
}
// @lc code=end

