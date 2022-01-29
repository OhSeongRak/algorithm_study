
def solution(routes):
    count = 0
    routes.sort()
    cameraIdx = routes[0][1]

    for start, end in routes[1:]:
        if start <= cameraIdx and cameraIdx < end:
            continue
        elif start < cameraIdx and end < cameraIdx:
            cameraIdx = end
        else:
            count += 1
            cameraIdx = end

    return count + 1

routes = [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
print(solution(routes))