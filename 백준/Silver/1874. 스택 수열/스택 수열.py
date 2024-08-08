N = int(input())
board = [int(input()) for _ in range(N)]
stack = []
cur = 1
result = ''
for b in board:
    while cur <= b:
        stack.append(cur)
        result += '+'
        cur += 1
    if stack and stack[-1] == b:
        result += '-'
        stack.pop()

if stack:
    print('NO')
else:
    print(*list(result), sep='\n')