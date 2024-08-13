for t in range(1, int(input()) + 1):
    N, L = map(int, input().split())

    arr = [list(map(int, input().split())) for _ in range(N)]

    result = 0
    for i in range(1, 1 << N):
        score, calo = 0, 0

        for j in range(N):
            if i & (1 << j) != 0:
                score += arr[j][0]
                calo += arr[j][1]

        if calo <= L:
            result = max(result, score)

    print(f'#{t} {result}')
