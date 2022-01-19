def solution(distance, rocks, n):
    answer = 0
    left = 0
    right = distance

    rocks.sort()
    rocks.append(distance)
    print(rocks)

    while(left <= right):
        cnt = 0
        mid = (left + right) // 2
        start_stone = 0

        for stone in rocks:
            dis = stone - start_stone

            if dis < mid:
                cnt += 1
            else:
                start_stone = stone

        if cnt <= n:
            left = mid + 1
        else:
            right = mid - 1


    return right


distance = 25
rocks = [2, 14, 11, 21, 17]
n = 2

print(solution(distance, rocks, n))