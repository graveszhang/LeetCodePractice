// Hash once

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> HashTable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (HashTable.containsKey(target-nums[i])){
                int idx = HashTable.get(target-nums[i]);
                return new int[]{idx, i};
            }
            else {
                HashTable.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
