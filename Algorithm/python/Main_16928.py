import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    ladder = {}
    snake = {}
    for _ in range(n):
        a, b = map(int, input().split())
        ladder[a] = b
    for _ in range(m):
        a, b = map(int, input().split())
        snake[a] = b
    queue = [1]
    visited = [0] * 101
    visited[1] = 1
    while queue:
        cur = queue.pop(0)
        if cur == 100:
            print(visited[cur] - 1)
            return
        for i in range(1, 7):
            nxt = cur + i
            if nxt > 100:
                continue
            if nxt in ladder:
                nxt = ladder[nxt]
            if nxt in snake:
                nxt = snake[nxt]
            if visited[nxt] == 0:
                visited[nxt] = visited[cur] + 1
                queue.append(nxt)


if __name__ == '__main__':
    main()
