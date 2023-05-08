import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M, B = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    mintime = math.inf
    maxheight = -1
    for height in range(257):
        inven = 0
        remove = 0
        for i in range(N):
            for j in range(M):
                curheight = board[i][j] - height
                if curheight < 0:
                    inven -= curheight
                else:
                    remove += curheight
        if remove + B >= inven:
            ttime = 2 * remove + inven
            if mintime >= ttime:
                mintime = ttime
                maxheight = height
    print(mintime, maxheight)


if __name__ == '__main__':
    main()
