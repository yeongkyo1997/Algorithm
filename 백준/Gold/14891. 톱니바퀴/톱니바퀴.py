import collections
import copy

board = [[]]
for _ in range(4):
    arr = collections.deque(list(map(int, input())))
    board.append(arr)
K = int(input())


def rotate(n, d):
    global board
    tmp = copy.deepcopy(board)
    tmp[n].rotate(d)

    # 왼쪽
    cur_d = d
    cur = n
    while cur + 1 <= 4:
        cur_d *= -1
        if board[cur][2] == board[cur + 1][-2]:
            break
        else:
            tmp[cur + 1].rotate(cur_d)
        cur += 1

    # 오른쪽
    cur_d = d
    cur = n
    while cur - 1 >= 1:
        cur_d *= -1
        if board[cur][-2] == board[cur - 1][2]:
            break
        else:
            tmp[cur - 1].rotate(cur_d)
        cur -= 1

    board = tmp


for _ in range(K):
    n, d = map(int, input().split())
    rotate(n, d)

result = 0
for i, b in enumerate(board[1:]):
    result += b[0] << i

print(result)
