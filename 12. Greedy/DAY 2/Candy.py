from typing import *
import random

def candy(ratings: List[int]) -> int:

    asc = []
    des = []
    sum = 0

    for i in range(len(ratings)):
        asc.append(1)
        des.append(1)

    for i in range(len(ratings) - 1):
        if ratings[i] < ratings[i + 1]:
            asc[i + 1] += asc[i]

    for i in range(len(ratings) - 1, 0, -1):
        if ratings[i] < ratings[i - 1]:
            des[i - 1] += des[i]

    for i in range(len(ratings)):
        sum += max(asc[i], des[i])

    return sum

#ratings = [3,  7, 8,  5,  3,  2,   6, 1, 5, 4]
ratings = [1, 0, 2]
print(candy(ratings))

# list = [3,  7, 8,  5,  3,  2,   6, 1, 5, 4]
# for i in range(10):
#      list[i] -= 1
#
# # for i in range(10):
# #     list.append(random.randrange(1, 10))
#
# print(list)