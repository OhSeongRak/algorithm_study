def solution(s):
    answer = 0
    tmp = ''
    dictionary = {'zero': 0, 'one': 1, 'two': 2, 'three': 3, 'four': 4, 'five': 5, 'six': 6, 'seven': 7,
                  'eight': 8, 'nine': 9}

    list_of_key=list(dictionary.keys())

    for i in range(0, len(s)):
        if s[i].isdigit():
            answer = answer * 10
            answer = answer + int(s[i])
        else:
            tmp = tmp + s[i]
            for j in range(0,len(dictionary)):
                if tmp==list_of_key[j]:
                    answer = answer * 10
                    answer = answer + dictionary[tmp]
                    tmp = ''

    return answer