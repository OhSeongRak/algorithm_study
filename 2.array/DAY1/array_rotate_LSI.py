import collections

# counterclockwise list -> deque and rotate(-((height*2) + (width*2) - 4)),  deque -> list.
# => clockwise list -> deque and  rotate(-1), deque -> list.
# N*M의 테두리 부분 => x += 1, y += 1, height(M) -= 2, width(N) -= 2 하며 반복하는데, 총 반복 횟수는 (N,M 중 더 작은 값 // 2)번이다.


def rotate(_col: int, _row: int, _height: int, _width: int, r: int) -> None:
    global lst
    deq = collections.deque()

    # list -> deque (clockwise: RIGHT -> DOWN -> LEFT -> UP)
    for run in range(_row, _row + width):  # RIGHT
        deq.append(lst[_col][run])
    # row+width-1 == end of row
    for run in range(_col + 1, _col + height):  # DOWN
        deq.append(lst[run][_row + width - 1])
    for run in range(_row + width - 2, _row, -1):  # LEFT
        deq.append(lst[_col + width - 1][run])
    # col+height-1 == end of col
    for run in range(_col + height - 1, _col, -1):  # UP
        deq.append(lst[run][_row])

    deq.rotate(-r)

    # deque -> list (clockwise)
    for run in range(_row, _row + width):  # RIGHT
        lst[_col][run] = deq.popleft()
    # row+width-1 == end of row
    for run in range(_col + 1, _col + height):  # DOWN
        lst[run][_row + width - 1] = deq.popleft()
    for run in range(_row + width - 2, _row, -1):  # LEFT
        lst[_col + width - 1][run] = deq.popleft()
    # col+height-1 == end of col
    for run in range(_col + height - 1, _col, -1):  # UP
        lst[run][_row] = deq.popleft()


if __name__ == "__main__":
    # input size of list(N*M), and number of rotates(R)
    N, M, R = map(int, input().rstrip().split())
    # input list(size: N*M)
    lst = [list(map(int, input().rstrip().split())) for _ in range(N)]

    col, row, height, width = 0, 0, N, M
    times = N//2 if N <= M else M//2

    for _ in range(times):
        rotate(col, row, height, width, R)

        col += 1
        row += 1
        height -= 2
        width -= 2

    for col in range(N):
        for row in range(M):
            print(lst[col][row], end=' ')
        print()
