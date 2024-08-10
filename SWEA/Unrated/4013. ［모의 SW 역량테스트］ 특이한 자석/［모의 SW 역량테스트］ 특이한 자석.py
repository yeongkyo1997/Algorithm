import collections
import copy

T = int(input())


def rotate(n, d):
    board[n].rotate(d)

    i = n
    nd = d
    while i + 1 < 4:
        nd = -nd
        if tmp[i][2] != tmp[i + 1][-2]:
            board[i + 1].rotate(nd)
        else:
            break
        i += 1

    i = n
    nd = d
    while i - 1 >= 0:
        nd = -nd
        if tmp[i][-2] != tmp[i - 1][2]:
            board[i - 1].rotate(nd)
        else:
            break
        i -= 1


for t in range(1, T + 1):
    K = int(input())
    board = [collections.deque(map(int, input().split())) for _ in range(4)]

    for _ in range(K):
        n, d = map(int, input().split())
        tmp = copy.deepcopy(board)
        rotate(n - 1, d)

    total = 0
    for i, b in enumerate(board):
        total += b[0] * (1 << i)

    print(f'#{t} {total}')
