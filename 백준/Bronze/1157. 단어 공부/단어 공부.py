import sys
from collections import Counter


def input(): return sys.stdin.readline().strip()


lib = Counter(input().upper())

result = sorted(lib.items(), key=lambda x: -x[1])

if len(result) == 1:
    print(result[0][0])
else:
    if result[0][1] == result[1][1]:
        print('?')
    else:
        print(result[0][0])