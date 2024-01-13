import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

for _ in range(N):
    vps = input()
    stack = []

    for i in vps:
        if i == '(':
            stack.append('(')
        else:
            if stack:
                stack.pop()
            else:
                print('NO')
                break
    else:
        if not stack:
            print('YES')
        else:
            print('NO')