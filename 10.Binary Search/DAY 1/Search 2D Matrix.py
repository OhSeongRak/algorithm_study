from typing import List

def binarySearch(arr, value):
    first, last = 0, len(arr) - 1

    while first <= last:
        mid = (first + last) // 2
        if arr[mid] == value:
            return True

        if arr[mid] > value:
            last = mid - 1
        else:
            first = mid + 1

    return False

def searchMatrix(matrix: List[List[int]], target: int) -> bool:

    for i in range(len(matrix)):
        if binarySearch(matrix[i], target):
            return True

    return False

matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
target = 5

print(searchMatrix(matrix, target))




