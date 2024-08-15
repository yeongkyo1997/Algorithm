def cnt_house(board, N, x, y, K):
    cnt = 0
    for i in range(N):
        for j in range(N):
            if abs(x - i) + abs(y - j) < K:
                cnt += board[i][j]
    return cnt


for t in range(1, int(input()) + 1):
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]

    result = 0

    for K in range(1, N + 2):
        cost = K * K + (K - 1) * (K - 1)
        for x in range(N):
            for y in range(N):
                houses = cnt_house(board, N, x, y, K)
                if houses * M >= cost:
                    result = max(result, houses)

    print(f'#{t} {result}')
