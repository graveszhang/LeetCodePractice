class Solution {
    Map<Character, Integer> tmap = new HashMap<>();
    Map<Character, Integer> smap = new HashMap<>();

    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        for (int i = 0; i < tlen; i++){
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        int l = 0, r = -1, len = Integer.MAX_VALUE;
        int newl = -1, newr = r;
        while (r < slen){
            r++; // slide right
            if (r < slen){
                char c = s.charAt(r);
                if (tmap.containsKey(c)) smap.put(c, smap.getOrDefault(c, 0)+1);
            }
            while (complete() && l <= r){
                if (r - l + 1 <= len){ // record l and r in case next round broke condition
                    len = r - l + 1;
                    newl = l;
                    newr = l + len;
                }
                char dc = s.charAt(l);
                if (tmap.containsKey(dc)) smap.put(dc, smap.getOrDefault(dc, 1) - 1);
                l++; // slide left
            }
        }
        return newl == -1 ? "" : s.substring(newl, newr);
    }

    private boolean complete(){ // check if still satisfy condition
        Iterator iter = tmap.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (smap.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}
