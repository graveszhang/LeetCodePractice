class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int volume = -1;
        while (right > left){
            volume = Math.max(volume, (right-left)*Math.min(height[left],height[right]));
            if (height[left] > height[right]){
                right--;
            } else {
                left++;
            }
            
        }
        return volume;
    }
}
