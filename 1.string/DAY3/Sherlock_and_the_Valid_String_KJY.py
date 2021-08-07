def isValid(s):
    s=list(s)
    s.sort()

    dictionary = {}
    count = 1
    for index in range(0,len(s)):
        if index==len(s)-1 or s[index] != s[index+1]:
            dictionary[s[index]]=count
            count=1
        else:
            count +=1

    print(dictionary)

    keys = list(dictionary.keys())
    min_value =dictionary.get(keys[0])
    max_value =dictionary.get(keys[0])
    min_value_cnt = 0
    max_value_cnt = 0



    for i in dictionary.keys():
        if min_value > dictionary.get(i):
            min_value=dictionary.get(i)
            min_value_cnt=1
        elif min_value == dictionary.get(i):
            min_value_cnt +=1

        if max_value < dictionary.get(i):
            max_value = dictionary.get(i)
            max_value_cnt =1
        elif max_value == dictionary.get(i):
            max_value_cnt +=1

    print(min_value, max_value, min_value_cnt, max_value_cnt)

    if min_value==max_value:
        return 'YES'
    if abs(min_value-max_value)>1 and min_value_cnt!= 1:
        return 'NO'
    if min_value_cnt == 1 and min_value == 1:
        return 'YES'
    if max_value_cnt == 1 and abs(min_value-max_value)<2:
        return 'YES'
    return 'NO'


s = input()
print(isValid(s))