def circularPalindromes(s):
    list_max_num = [1 for i in range(len(s))]

    circular_s = s + s[0:len(s)-1]

    for jump_num in range(1,len(s)):
        for j in range(0, len(s)):
            if circular_s[j:j+jump_num+1]==(circular_s[j+jump_num:j:-1]+circular_s[j]):
                for k in range(0,len(s)):
                    if j+jump_num >=len(s):
                        if (j+jump_num)%len(s) >= k:
                            continue
                    if j < k <= j+jump_num:
                        continue
                    else:
                        if list_max_num[k % len(s)] < len(circular_s[j:j + jump_num + 1]):
                            list_max_num[k % len(s)] = len(circular_s[j:j + jump_num + 1])
    return list_max_num

print(circularPalindromes('eededdeedede'))