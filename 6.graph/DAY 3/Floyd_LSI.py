import sys

if __name__ == "__main__":
    cities = int(input())
    buses = int(input())

    bus_info = [[sys.maxsize] * (cities+1) for _ in range(cities+1)]  # 0-index space is dummy space

    for _ in range(buses):
        start, end, cost = map(int, input().split())
        if bus_info[start][end] > cost:
            bus_info[start][end] = cost

    # Floyd Warshall, O(N^3)
    for path in range(1, cities+1):
        for start in range(1, cities+1):
            for end in range(1, cities+1):
                if start == end:
                    bus_info[start][end] = 0  # main diagonal = 0
                else:
                    bus_info[start][end] = min(bus_info[start][end],
                                               bus_info[start][path] + bus_info[path][end])

    for start in range(1, cities+1):
        for end in range(1, cities+1):
            if bus_info[start][end] == sys.maxsize:
                print(0, end=" ")
            else:
                print(bus_info[start][end], end=" ")
        print()
