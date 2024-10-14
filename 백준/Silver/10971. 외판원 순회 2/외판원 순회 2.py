import itertools
import math
import sys


if __name__ == '__main__':
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]
    result = math.inf

    for perm in itertools.permutations(range(N), N):
        perm = list(perm)
        perm.append(perm[0])

        start = perm[0]

        total = 0
        for nxt in perm[1:]:
            if board[start][nxt] == 0:
                break
            total += board[start][nxt]
            start = nxt
        else:
            result = min(result, total)

    print(result)