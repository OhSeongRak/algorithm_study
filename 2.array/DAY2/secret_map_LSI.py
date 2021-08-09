def solution(n, arr1, arr2):
    table = str.maketrans({'1': '#', '0': ' '})
    lines = [format(i | j, 'b').zfill(n) for i, j in zip(arr1, arr2)]

    return [line.translate(table) for line in lines]
