import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

stack = []
result = []
cnt = 1
for _ in range(int(input())):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        result.append('+')
        cnt += 1
    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        print('NO')
        exit(0)
print('\n'.join(result))