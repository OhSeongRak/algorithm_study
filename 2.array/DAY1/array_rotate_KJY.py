def func_rotate():
    input_N , input_M , input_R= input().split()
    input_N , input_M , input_R = int(input_N),int(input_M),int(input_R)

    input_list= []

    for i in range(0,input_N):
        input_list.append(input().split())

    ####################################################################################################################

    for j in range(0,input_R):
        for i in range(0,int(min(input_N,input_M)/2)):
            remember_start_point_value= input_list[i][i]
            x= i
            y= i
            # <-
            while x<=input_M-2 - (i):
                input_list[y][x]=input_list[y][x+1]
                x +=1

            # 위로
            while y<=input_N-2-i:
                input_list[y][x]=input_list[y+1][x]
                y +=1

            # ->
            while x>= 1 + i:
                input_list[y][x]=input_list[y][x-1]
                x -=1

            # 아래로
            while y>= 2 + i:
                input_list[y][x]= input_list[y-1][x]
                y -=1

            input_list[y][x] = remember_start_point_value

    for i in range(0,input_N):
        for j in range(0,input_M):
            print(input_list[i][j],end=' ')
        print('')

func_rotate()
