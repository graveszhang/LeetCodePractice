class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;    
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); // Arraylist size not fixed
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;

            for (int second = first + 1; second < n-1; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                
                if (nums[first] + nums[second] + nums[third]== 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
