def partition(list,left,right):
    low = left+1
    high = right
    pivot = list[left]

    while low<=high:
        while low<=high and list[low]<=pivot:
            low=low+1
        while low<=high and list[high]>=pivot:
            high=high-1
        if low<=high:
            tmp = list[low]
            list[low]=list[high]
            list[high]=tmp

    tmp = list[left]
    list[left]=list[high]
    list[high]=tmp

    return high
def quick_sort(list,left,right):
    if left<right:
        q = partition(list,left,right)
        quick_sort(list,left,q-1)
        quick_sort(list,q+1,right)

T = int(input())

for test_case in range(1, T + 1):

    K = int(input())
    str = input()

    part_str = []
    #pre_index
    #back_index
    for start_index in range(0,len(str)):
        for end_index in range(0,len(str)):
            part_str.append(str[start_index:end_index+1])

    part_str = list(set(part_str))


    quick_sort(part_str,0,len(part_str)-1)



    print('#',end='')
    print(test_case,end=' ')
    if K>=len(part_str) or K<=0:
        print('none')
    else:
        print(part_str[K])