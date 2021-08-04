"""
- Brute Force => O(N^2)
- Sliding Window => Two Pointer(not sorting) => O(N)
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        duplicate, left = {}, 0
        max_length = 0

        for right in range(len(s)):
            if s[right] not in duplicate:
                max_length = max(max_length, right - left + 1)
            else:
                if duplicate[s[right]] < left:
                    max_length = max(max_length, right - left + 1)
                else:
                    left = duplicate[s[right]] + 1

            duplicate[s[right]] = right

        return max_length
