import math

N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]

result = math.inf


def dfs(path, depth, start):
    global result
    if depth == N // 2:
        start_score = 0
        link_score = 0

        start_set = path
        link_set = set(range(0, N)) - path
        for i in start_set:
            for j in start_set:
                if i != j:
                    start_score += board[i][j]
        for i in link_set:
            for j in link_set:
                if i != j:
                    link_score += board[i][j]
        result = min(abs(start_score - link_score), result)
        return

    for i in range(start, N):
        path.add(i)
        dfs(path, depth + 1, i + 1)
        path.discard(i)


dfs(set(), 0, 0)
print(result)