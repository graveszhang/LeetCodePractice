class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> HashTable = new HashMap<Character, Integer>();
        int head = -1;
        int len = 0;
        for (int i = 0; i < s.length(); i++){
            if (HashTable.containsKey(s.charAt(i)) && HashTable.get(s.charAt(i)) > head)
                head = HashTable.get(s.charAt(i));
            else len = Math.max((i - head), len);
            HashTable.put(s.charAt(i),i);
        }
        return len;
    }
}
