import sys


def input(): return sys.stdin.readline().rstrip()


n = input()
n = ''.join(sorted(n, reverse=True))

if n[-1] == '0':
    if sum(map(int, n)) % 3 == 0:
        print(n)
    else:
        print(-1)
else:
    print(-1)