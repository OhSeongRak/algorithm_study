from typing import *

# def canCompleteCircuit(gas: List[int], cost: List[int]) -> int:
#
#     if sum(gas) < sum(cost):
#         return -1
#
#     for i in range(len(gas)):
#         if gas[i] < cost[i]:
#             continue
#
#         tank = gas[i]
#         for j in range(i + 1, len(gas) + i + 1):
#             costIndex = (j - 1) % len(gas)
#             gasIndex = j % len(gas)
#             tank -= cost[costIndex]
#             if tank < 0:
#                 break
#             tank += gas[gasIndex]
#
#         if tank - gas[i] >= 0:
#             return i
#
#     return 1

def canCompleteCircuit(gas: List[int], cost: List[int]) -> int:

    answer = 0
    tank = 0

    if sum(gas) < sum(cost):
        return -1

    for i in range(len(gas)):
        tank += gas[i] - cost[i]
        if tank < 0:
            answer = i + 1
            tank = 0

    return answer

gas = [0,0,2,0]
cost = [0,0,0,1]

print(canCompleteCircuit(gas, cost))