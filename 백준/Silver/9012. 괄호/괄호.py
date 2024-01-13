import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

for _ in range(N):
    vps = input()

    while '()' in vps:
        vps = vps.replace('()', '')

    if not vps:
        print("YES")
    else:
        print('NO')