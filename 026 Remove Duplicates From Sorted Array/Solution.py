class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        length = 0
        prev = -9999999 ##dummy int for comparation
        index = 0
        while(index<len(nums)):
            if nums[index] != prev:
                length += 1
                prev = nums[index]
                index += 1
            else:
                if(index+1==len(nums)):
                    break
                nums[index:] = nums[index+1:]
        return length
