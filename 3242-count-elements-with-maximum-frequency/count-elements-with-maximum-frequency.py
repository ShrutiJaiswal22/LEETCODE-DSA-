from collections import Counter
from typing import List

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq = Counter(nums)                # count frequencies
        max_freq = max(freq.values())       # get maximum frequency
        return sum(count for count in freq.values() if count == max_freq)
