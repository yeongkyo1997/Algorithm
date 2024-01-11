import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())
stack = []
result = []
cur = 1

for i in range(n):
    num = int(input())

    while cur <= num:
        stack.append(cur)
        result.append('+')
        cur += 1

    if stack[-1] == num:
        stack.pop()
        result.append('-')
    else:
        print('NO')
        break
else:
    for i in result:
        print(i)