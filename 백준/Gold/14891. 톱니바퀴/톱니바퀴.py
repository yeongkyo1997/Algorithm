import collections
import copy

board = [[]]
board.extend(collections.deque(map(int, input().rstrip())) for _ in range(4))
K = int(input())


def rotate(n, rt):
    left = n
    right = n

    nrt = rt
    while left - 1 >= 1:
        if tmp[left - 1][2] == tmp[left][-2]:
            break
        nrt *= -1
        board[left - 1].rotate(nrt)
        left -= 1

    nrt = rt
    while right + 1 <= 4:
        if tmp[right][2] == tmp[right + 1][-2]:
            break
        nrt *= -1
        board[right + 1].rotate(nrt)
        right += 1



for _ in range(K):
    n, rt = map(int, input().rstrip().split())
    tmp = copy.deepcopy(board)
    board[n].rotate(rt)
    rotate(n, rt)

result = 0
for i in range(4):
    if board[i + 1][0] == 1:
        result += 1 << i
print(result)