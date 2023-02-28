import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 7569 토마토
def main():
    m, n, h = map(int, input().split())
    box = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
    queue = []
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if box[i][j][k] == 1:
                    queue.append((i, j, k))
    while queue:
        i, j, k = queue.pop(0)
        for di, dj, dk in ((-1, 0, 0), (1, 0, 0), (0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1)):
            ni, nj, nk = i + di, j + dj, k + dk
            if 0 <= ni < h and 0 <= nj < n and 0 <= nk < m and box[ni][nj][nk] == 0:
                box[ni][nj][nk] = box[i][j][k] + 1
                queue.append((ni, nj, nk))
    result = 0
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if box[i][j][k] == 0:
                    print(-1)
                    return
                result = max(result, box[i][j][k])
    print(result - 1)


if __name__ == '__main__':
    main()
