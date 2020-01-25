class Solution:
    def maxArea(self, height: List[int]) -> int:
        water = 0
        head = 0
        tail = len(height) - 1

        for i in range(len(height)):
            
            if tail <= head:
                break
                
            width = abs(head - tail)

            if height[head] < height[tail]:   
                res = width * height[head]
                head += 1
            else:
                res = width * height[tail]
                tail -= 1

            if res > water:
                water = res
                
        return water
