N, M = map(int, input().split())
arr = sorted(map(int, input().split()))

result = set()


def dfs(path, depth, flag):
    if depth == M:
        result.add(tuple(path))
        return

    for i in range(N):
        if flag & (1 << i) == 0:
            path.append(arr[i])
            dfs(path, depth + 1, flag | (1 << i))
            path.pop()


dfs([], 0, 0)

for r in sorted(result):
    print(*r)