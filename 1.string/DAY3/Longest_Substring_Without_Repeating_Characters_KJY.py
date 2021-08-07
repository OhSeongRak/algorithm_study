class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        for i in range(0,len(s)):
            count = 0
            for j in range(i,len(s)):
                count +=1
                if len(s[i:j+2])!=len(set(s[i:j+2])):
                    break
            if result < count:
                result = count
            count=0
        return result