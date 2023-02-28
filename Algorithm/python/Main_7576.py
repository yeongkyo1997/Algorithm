import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 7576 토마토
def main():
    m, n = map(int, input().split())
    box = [list(map(int, input().split())) for _ in range(n)]
    q = []
    for i in range(n):
        for j in range(m):
            if box[i][j] == 1:
                q.append((i, j))
    while q:
        x, y = q.pop(0)
        for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                q.append((nx, ny))
    result = -2
    for i in range(n):
        for j in range(m):
            if box[i][j] == 0:
                print(-1)
                return
            result = max(result, box[i][j])
    print(result - 1)


if __name__ == '__main__':
    main()
