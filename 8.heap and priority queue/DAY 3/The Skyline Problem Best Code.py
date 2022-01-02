import heapq

def getSkyline(buildings):
    events = sorted([(L, -H, R) for L, R, H in buildings] + list({(R, 0, None) for _, R, _ in buildings}))
    res, hp = [[0, 0]], [(0, float("inf"))]

    for x, negH, R in events:
        while x >= hp[0][1]:
            heapq.heappop(hp)
        if negH:
            heapq.heappush(hp, (negH, R))
        if res[-1][1] + hp[0][0]:
            res.append([x, -hp[0][0]])
    return res[1:]

buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]

print(getSkyline(buildings))