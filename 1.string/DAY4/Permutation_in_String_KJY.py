class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        start_flag = 0
        s1 = list(s1)
        for index in range(0, len(s2)):
            if s2[index] in s1:
                s1.remove(s2[index])
                start_flag = 1
                if len(s1) == 0:
                    return True
            else:
                if start_flag == 1:
                    return False
s=Solution()
#false!
print(s.checkInclusion("ab","eidboaoo"))
#false!
print(s.checkInclusion("dinitrophenylhydrazine","acetylphenylhydrazine"))
print(s.checkInclusion("a","dcda"))