H, W = map(int, input().rstrip().split())

board = list(map(int, input().rstrip().split()))

result = 0
for i in range(1, W - 1):
    left = max(board[:i])
    right = max(board[i + 1:])
    result += max(0, min(left, right) - board[i])

print(result)