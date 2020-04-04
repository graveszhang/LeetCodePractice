class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) <= 2:
            return 0
        prev = 0
        water = 0
        middle = max(height)
        x = height.index(middle)

        for i in range(0,x):
            if (prev > height[i]):
                water += (prev - height[i])
            else:
                prev = height[i]
        
        prev = 0 ## clear prev data

        for i in range(len(height)-1, x, -1):
            if (prev > height[i]):
                water += (prev - height[i])
            else:
                prev = height[i]

        return water
