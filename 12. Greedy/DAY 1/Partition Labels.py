from typing import *

def partitionLabels(s: str) -> List[int]:

    dic = {}

    for i, k in enumerate(s):
        if not dic.get(k):
            dic[k] = [i, i]
        else:
            dic[k][1] = i

    valueList = list(dic.values())

    start = valueList[0][0]
    end = valueList[0][1]
    answer = []

    for i, j in valueList[1:]:
        if i < end and end < j:
            end = j
        elif i < end and j < end:
            continue
        else:
            answer.append(end - start + 1)
            start = i
            end = j

    answer.append(end - start + 1)
    return answer

s = "ababcbacadefegdehijhklij"
print(partitionLabels(s))