import sys


def input(): return sys.stdin.readline().rstrip()


st = input().split('-')

result = 0
for i in range(len(st)):
    if i == 0:
        result += sum(map(int, st[0].split('+')))
    else:
        result -= sum(map(int, st[i].split('+')))

print(result)