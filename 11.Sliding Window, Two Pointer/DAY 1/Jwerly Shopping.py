from collections import deque

def solution(gems):
    cnt = 0
    start = 1
    end = 0
    minStart = 0
    minEnd = 0
    minLen = len(gems) + 1
    dic = {}
    deq = deque()

    for k in gems:
        dic[k] = dic.get(k, 0)

    # deq.append(gems[0])
    # dic[gems[0]] += 1

    for i in range(len(gems)):
        end = i
        if dic.get(gems[i]) == 0:
            cnt += 1

        dic[gems[i]] += 1
        deq.append(gems[i])
        end += 1

        while dic[deq[0]] > 1 and deq[0] == gems[i]:
            dic[deq[0]] -= 1
            deq.popleft()
            start += 1

        if cnt == len(dic.keys()):
            while len(deq) >= 2 and deq[0] == deq[1]:
                deq.popleft()
                start += 1

            for j in reversed(range(len(deq) - 1)):
                if deq[j] == deq[j - 1]:
                    end -= 1
                else:
                    break

            if end - start + 1 < minLen:
                minStart = start
                minEnd = end
                minLen = end - start + 1

    return [minStart, minEnd]

gems = ["a", "b", "b", "b","c","b","a"]
print(solution(gems))

