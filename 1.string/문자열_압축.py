def solution(s):
    answer = len(s)

    if len(s) == 1:
        return 1

    for start in range(1, len(s)//2 + 1):
        compressed, count = '', 1
        for stop in range(0, len(s), start):
            if s[stop: stop+start] == s[stop+start: stop + 2*start]:
                count += 1
            else:
                if count == 1:
                    compressed += s[stop: stop+start]
                else:
                    compressed += str(count) + s[stop: stop+start]
                    count = 1

        answer = min(answer, len(compressed))

    return answer


print(solution('zbacacxq'))