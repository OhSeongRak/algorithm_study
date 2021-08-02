def solution(s):
    answer = len(s)

    for unit in range(1,int(len(s)/2)+1):
        index = 0
        count = 0
        s_divisor_str=''
        while index<len(s):
            if s[index:index+unit]==s[index+unit:index+unit+unit]:
                count += 1
                index += unit
            else:
                if count==0:
                    s_divisor_str +=s[index:index+unit]
                else:
                    s_divisor_str += str(count+1)
                    s_divisor_str +=s[index:index+unit]
                    count=0
                index += unit

        if answer > len(s_divisor_str):
            answer=len(s_divisor_str)


    return answer
