import sys

input = lambda: sys.stdin.readline().rstrip()


def check(n):
    if n < 0 or n > 100000 or visited[n]:
        return False
    return True


def bfs():
    while q:
        data, depth = q.pop(0)
        if data == K:
            return depth
        if check(data - 1):
            visited[data - 1] = True
            q.append([data - 1, depth + 1])
        if check(data + 1):
            visited[data + 1] = True
            q.append([data + 1, depth + 1])
        if check(data * 2):
            visited[data * 2] = True
            q.append([data * 2, depth + 1])


N, K = map(int, input().split())
visited = [False] * 100001
q = [[N, 0]]
visited[N] = True
print(bfs(N))
