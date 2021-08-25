from typing import *
from collections import deque


def solution(bridge_length: int, weight: int, truck_weights: List[int]) -> int:
    dummy, time = 0, 0
    bridge, truck_weight_on_bridge = deque([dummy] * bridge_length, maxlen=bridge_length), 0

    while truck_weights:
        time += 1
        truck_weight_on_bridge -= bridge.pop()
        if truck_weight_on_bridge + truck_weights[0] <= weight:
            entered_truck = truck_weights.pop(0)
            bridge.appendleft(entered_truck)
            truck_weight_on_bridge += entered_truck
        else:
            bridge.appendleft(dummy)

    # After the last truck has entered the bridge,
    # we need to wait for the truck to cross the bridge.
    return time + bridge_length
