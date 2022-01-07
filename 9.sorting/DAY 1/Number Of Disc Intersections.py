def solution(A):

    length = len(A)
    lower = []
    upper = []

    for i in range(length):
        lower.append(i - A[i])
        upper.append(i + A[i])

    lower.sort()
    upper.sort()

    intersection = 0
    j = 0

    for i in range(len(A)):
        while j < len(A) and lower[j] <= upper[i]:
            intersection += j
            intersection -= i
            j += 1

    return intersection if intersection <= 10000000 else -1

A = [1, 5, 2, 1, 4, 0]


print(solution(A))
