from lib import *
"""
- 문자열의 순열을 직접 구한다 => itertools.permutations => Time Limit Exceeded, O(N^2) 
- 슬라이딩 윈도우 => 문자열(s2) 순열 == 문자열(s2)의 문자를 조합한 모든 경우 => 문자열(s2[:]) 내 문자의 개수(Count)만 같으면 된다.
  => len(s1) = N, len(s2) = M, O(M-N),
"""


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_count = collections.Counter(s1)

        if len(s1) > len(s2):
            return False

        for i in range(len(s2) - len(s1) + 1):
            s2_substring = s2[i: i+len(s1)]
            if collections.Counter(s2_substring) == s1_count:
                return True

        return False
