import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

for _ in range(N):
    vps = input()

    while vps.find('()') != -1:
        vps = vps.replace('()', '')

    if not vps:
        print("YES")
    else:
        print('NO')