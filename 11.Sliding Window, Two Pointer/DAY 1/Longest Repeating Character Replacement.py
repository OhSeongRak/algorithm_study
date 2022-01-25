from collections import deque

def characterReplacement(s: str, k: int) -> int:
    maxLen = 0
    cnt = 0
    dic = {}
    deq = deque()

    for i in range(len(s)):
        dic[s[i]] = dic.get(s[i], 0) + 1
        deq.append(s[i])

        if len(dic) > 1:
            cnt += 1

        if cnt > k:
            if maxLen < len(deq) - 1:
                maxLen = len(deq) - 1

    return 1

s = "AABABBA"
k = 2

print(characterReplacement(s, k))
