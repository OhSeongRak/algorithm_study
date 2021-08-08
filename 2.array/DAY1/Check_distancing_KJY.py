def Manhattan_distance(person_1 ,person_2):
    r1 = person_1[0]
    c1 = person_1[1]
    r2 = person_2[0]
    c2 = person_2[1]
    return abs(r1 -r2) +abs(c1 -c2)

def solution(places):

    answer = [-1 for i in range(len(places))]

    for i in range(0,len(places)):
        person_position = []

        for j in range(0,len(places[i])):
            for k in range(0,len(places[i][j])):
                if places[i][j][k] == 'P':
                    person_position.append([j,k])

        for person_1 in person_position:
            for person_2 in person_position:
                if Manhattan_distance(person_1,person_2)==0:
                    continue
                elif Manhattan_distance(person_1,person_2)==1:
                    answer[i]=0
                elif Manhattan_distance(person_1,person_2)==2:
                    # 대각으로 있는경우
                    if abs(person_2[0]-person_1[0])==1:
                        # ↗ 대각
                        if person_1[0]+person_1[1] == person_2[0]+person_2[1]:
                            if places[i][min(person_1[0],person_2[0])][min(person_1[1],person_2[1])]=='X'and places[i][max(person_1[0],person_2[0])][max(person_1[1],person_2[1])]=='X':
                                continue
                            else:
                                answer[i]=0
                        # ↘ 대각
                        else:
                            if places[i][min(person_1[0],person_2[0])][max(person_1[1],person_2[1])]=='X'and places[i][max(person_1[0],person_2[0])][min(person_1[1],person_2[1])]=='X':
                                continue
                            else:
                                answer[i]=0
                    # 나란히 있는경우
                    else:
                        # 사이가 판넬이면
                        if places[i][int((person_1[0]+person_2[0])/2)][int((person_1[1]+person_2[1])/2)]=='X':
                            continue
                        # 사이가 탁자거나 사람이면
                        else:
                            answer[i]=0
                else:
                    continue
        if answer[i]!=0:
            answer[i]=1
    return answer

print(solution(
    [["POOOP",
      "OXXOX",
      "OPXPX",
      "OOXOX",
      "POXXP"],
     ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
     ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
     ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
     ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
))