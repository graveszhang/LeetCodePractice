class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        prev = nums[0]
        for i in nums[1:]:
            if i == prev:
                flag = True
            else: 
                prev = i
