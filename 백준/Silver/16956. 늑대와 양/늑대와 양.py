N, M = [int(x) for x in input().split()]
arr = [input().replace('.', 'D') for i in range(N)]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'S':
            if i - 1 >= 0 and arr[i - 1][j] == "W":
                print(0)
                exit(0)
            elif i + 1 < N and arr[i + 1][j] == "W":
                print(0)
                exit(0)
            elif j - 1 >= 0 and arr[i][j - 1] == "W":
                print(0)
                exit(0)
            elif j + 1 < M and arr[i][j + 1] == "W":
                print(0)
                exit(0)
 
print(1)

for i in range(N):
    for j in range(M):
        print(arr[i][j], end='')
    print("")
