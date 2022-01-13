def solution(citations):

    citations.sort()
    answer = citations[0]

    for i in range(len(citations)):
        if citations[i] >= len(citations) - i:
            return len(citations) - i

    return answer

citations = [3, 4,9,10,11,12,14]
print(solution(citations))