class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
#################################################        #####################################
        new_s=[]
        first_alpha = 1
        for i in range(0, len(s)):
            # 중복 검사 변수
            overlap_flag = 0
            # 중복 검사 하기
            for j in range(0, i):
                if s[i]==s[j]:
                    overlap_flag=1
                    break
            # 중복이라면
            if overlap_flag ==1:
                new_s.append(new_s[j])
            # 중복이 아니라면
            else:
                new_s.append(first_alpha)
                first_alpha = first_alpha +1
#######################################
        new_t = []
        first_alpha = 1
        for i in range(0, len(t)):
            # 중복 검사 변수
            overlap_flag = 0
            # 중복 검사 하기
            for j in range(0, i):
                if t[i] == t[j]:
                    overlap_flag = 1
                    break
            # 중복이라면
            if overlap_flag == 1:
                new_t.append(new_t[j])
            # 중복이 아니라면
            else:
                new_t.append(first_alpha)
                first_alpha = first_alpha + 1
###################################################
        if new_s==new_t:
            return True
        else:
            return False
 
