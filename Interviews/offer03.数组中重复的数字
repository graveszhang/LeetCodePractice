class Solution {
/*
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (hashmap.containsKey(nums[i])) return nums[i]; 
            else hashmap.put(nums[i], 1);
        }
        return -1;
    }
*/
    // 执行用时: 9 ms
    // 内存消耗: 47.5 MB

/*
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (set.add(nums[i]) == false) return nums[i];
        }
        return -1;
    }
    // 执行用时：5 ms
    // 内存消耗：48.5 MB
*/
    public int findRepeatNumber(int[] nums) {
        int tmp;
        for(int i = 0;i < nums.length;i++){
            while (nums[i] != i){
                if(nums[i]==nums[nums[i]]) return nums[i];
                tmp=nums[i];
                nums[i]=nums[tmp];
                nums[tmp]=tmp;
            }
        }
        return -1;
    }
    // 执行用时：0 ms
    // 内存消耗：46.2 MB
}
