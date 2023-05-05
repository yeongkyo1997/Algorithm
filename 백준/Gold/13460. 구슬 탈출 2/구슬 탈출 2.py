import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    board = [list(input()) for _ in range(n)]
    visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]
    move = ((0, 1), (0, -1), (1, 0), (-1, 0))
    q = collections.deque()

    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                rx, ry = i, j
                board[i][j] = '.'
            elif board[i][j] == 'B':
                bx, by = i, j
                board[i][j] = '.'
    q.append((rx, ry, bx, by, 0))
    visited[rx][ry][bx][by] = True
    ans = -1
    while q:
        rx, ry, bx, by, cnt = q.popleft()
        if cnt > 10:
            break
        if board[rx][ry] == 'O':
            ans = cnt
            break
        for dx, dy in move:
            nrx, nry, ncnt = rx, ry, 0
            while board[nrx + dx][nry + dy] != '#' and board[nrx][nry] != 'O':
                nrx += dx
                nry += dy
                ncnt += 1
            nbx, nby, ncnt2 = bx, by, 0
            while board[nbx + dx][nby + dy] != '#' and board[nbx][nby] != 'O':
                nbx += dx
                nby += dy
                ncnt2 += 1
            if board[nbx][nby] == 'O':
                continue
            if nrx == nbx and nry == nby:
                if ncnt > ncnt2:
                    nrx -= dx
                    nry -= dy
                else:
                    nbx -= dx
                    nby -= dy
            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = True
                q.append((nrx, nry, nbx, nby, cnt + 1))
    print(ans)


if __name__ == '__main__':
    main()
