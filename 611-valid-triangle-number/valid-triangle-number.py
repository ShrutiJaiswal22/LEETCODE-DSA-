
from typing import List

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        count = 0
        
        for k in range(n - 1, 1, -1):  # fix the largest side c = nums[k]
            i, j = 0, k - 1
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    # all elements from i..j-1 with nums[j] form valid triangles
                    count += (j - i)
                    j -= 1
                else:
                    i += 1
        return count
