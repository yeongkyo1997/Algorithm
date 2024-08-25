# 꿀통 선택


def choose_honey(path, depth):
    if depth == 2:
        honey.append(path)
        return
    for row in range(N):
        for col in range(N - M + 1):
            if any(visited[row][col:col + M]):
                continue
            for i in range(M):
                visited[row][col + i] = True
            choose_honey(path + [board[row][col:col + M]], depth + 1)
            for i in range(M):
                visited[row][col + i] = False


# 꿀통 최대 수익 구하기(부분집합 사용)
def subset(honey):
    result = 0

    for i in range(1 << M):
        total = 0
        _sum = 0
        for j in range(M):
            if i & (1 << j) == 0:
                _sum += honey[j]
                total += honey[j] ** 2
        if _sum <= C:
            result = max(result, total)

    return result


for t in range(1, int(input().rstrip()) + 1):
    N, M, C = map(int, input().rstrip().split())
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]

    honey = []
    visited = [[False] * N for _ in range(N)]
    choose_honey([], 0)
    result = 0
    for h in honey:
        total = 0
        for _h in h:
            total += subset(_h)
        result = max(total, result)
    print(f'#{t} {result}')
