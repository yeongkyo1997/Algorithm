N, M = map(int, input().split())


def combination(N, M):
    result = []

    def dfs(path, start):
        if len(path) == M:
            result.append(path[:])
            return
        for i in range(start, N + 1):
            path.append(i)
            dfs(path, i + 1)
            path.pop()

    dfs([], 1)

    return result


result = combination(N, M)
for i in result:
    print(*i)