class Solution:
    def maxArea(self, height: List[int]) -> int:
        if len(height) == 2:
            return min(height)
        area = 0
        l = 0 
        r = len(height) - 1
        while l < r:
            area = max((r-l) * min(height[l],height[r]), area)
            if height[l] < height[r]:
                l = l + 1
            else: 
                r = r - 1
        return area
