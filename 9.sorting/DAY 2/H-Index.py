def solution(citations):
    citations.sort(reverse=True)

    for i, c in enumerate(citations, start=1):
        if i > c:
            return i - 1

    return len(citations)
