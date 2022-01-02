from typing import *

def ParkingTower(Ri: List[int], Wi: List[int]) -> int:
    price = 0
    parking = [0 for i in range(len(Ri))]
    waiting = []

    for k in range(len(Wi) * 2):
        i = int(input())
        flag = 0
        if i > 0:
            for j in range(len(parking)):
                if parking[j] == 0:
                    price += Ri[j] * Wi[i - 1]
                    parking[j] = i
                    flag = 1
                    break
            if flag == 0:
                waiting.append(i)

        else:
            for j in range(len(parking)):
                if parking[j] == -i:
                    if waiting:
                        parking[j] = waiting.pop(0)
                        price += Ri[j] * Wi[parking[j] - 1]
                        break
                    else:
                        parking[j] = 0
        print('parking: ',parking)
        print('waiting: ',waiting)

    return price

TC = int(input())

for i in range(TC):
    Ri = []
    Wi = []
    n, m = list(map(int, input().split()))

    for j in range(n):
        Ri.append(int(input()))

    for j in range(m):
        Wi.append(int(input()))

    print('#{0} {1}'.format(i+1, ParkingTower(Ri, Wi)))

