from bisect import bisect_left

# def findKthNumber(m: int, n: int, k: int) -> int:
#     list = []
#
#     for i in range(m):
#         for j in range(n):
#             index = bisect_left(list, (i + 1) * (j + 1))
#             list.insert(index, (i + 1) * (j + 1))
#
#     print(list)
#
#     return list[k - 1]

# def findKthNumber(m: int, n: int, k: int) -> int:
#     dic = {}
#     for i in range(m):
#         for j in range(n):
#             dic[(i + 1) * (j + 1)] = dic.get((i + 1) * (j + 1), 0) + 1
#
#     list = sorted(dic.items())
#
#     print(list)
#
#     for key, values in list:
#         k -= values
#         if k <= 0:
#             return key
#
#     return 0

def findKthNumber(m: int, n: int, k: int) -> int:

    left = 1
    right = m * n

    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        height = 1

        while height <= mid and height <= m:
            cnt += mid // height if mid // height <= n else n
            height += 1

        if cnt <= k:
            left = mid + 1
        else:
            right = mid - 1


    return right

m = 5
n = 6
k = 20

print(findKthNumber(m, n, k))