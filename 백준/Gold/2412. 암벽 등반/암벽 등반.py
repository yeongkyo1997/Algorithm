import collections

n, T = map(int, input().rstrip().split())

point = set()

for _ in range(n):
    x, y = map(int, input().rstrip().split())

    point.add((x, y))


def bfs(x, y):
    q = collections.deque()
    q.append((x, y, 0))
    visited = set()
    visited.add((x, y))
    while q:
        x, y, depth = q.popleft()
        if y == T:
            return depth
        for i in range(-2, 3):
            for j in range(-2, 3):
                nx, ny = x + i, y + j
                if (nx, ny) in point and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    q.append((nx, ny, depth + 1))

    return -1


print(bfs(0, 0))