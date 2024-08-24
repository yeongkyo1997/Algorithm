def check(arr, N, X):
    visited = set()

    for i in range(N - 1):
        if arr[i] == arr[i + 1]:
            continue
        if abs(arr[i] - arr[i + 1]) > 1:
            return 0
        elif arr[i] - arr[i + 1] == 1:
            for j in range(i + 1, i + 1 + X):
                if j >= N:
                    return 0
                if arr[i] != arr[j] and j in visited:
                    return 0
                visited.add(j)
        elif arr[i + 1] - arr[i] == 1:
            for j in range(i, i - X, -1):
                if j < 0:
                    return 0
                if arr[i + 1] != arr[j] and j in visited:
                    return 0
                visited.add(j)

    return 1


for t in range(1, int(input().rstrip()) + 1):
    N, X = map(int, input().rstrip().split())
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]
    result = 0
    for b in board:
        result += check(b, N, X)

    board = list(map(list, zip(*board)))
    for b in board:
        result += check(b, N, X)

    print(f'#{t} {result}')
