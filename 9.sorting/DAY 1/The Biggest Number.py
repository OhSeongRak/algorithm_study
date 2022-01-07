def solution(numbers):
    answer = []
    list = []
    string = ''
    maxLen = 0

    for i in range(len(numbers)):
        list.append("{}".format(numbers[i]))

    for k in list:
        if maxLen < len(k):
            maxLen = len(k)

    for k in list:
        str = k
        for i in range(maxLen - len(k)):
            str += k[-1]
        answer.append([str, k])

    answer.sort(reverse=True)
    print(answer)

    for k in answer:
        string += k[1]

    return string

def solution(numbers):
    list = []
    answer = ""

    for i in range(len(numbers)):
        list.append("{}".format(numbers[i]))

    print(list)

    for i in range(len(list) - 1):
        for j in range(len(list) - i - 1):
            if list[j] + list[j + 1] < list[j + 1] + list[j]:
                temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp

    for k in list:
        answer += k

    return answer

numbers = [3, 342, 9, 34, 5, 0]

print(solution(numbers))
