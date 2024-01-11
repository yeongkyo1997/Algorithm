from collections import Counter
import sys


def input(): return sys.stdin.readline().strip()


a, b, c = [int(input()) for _ in range(3)]

lib = Counter(str(a * b * c))

for i in range(10):
    print(lib[str(i)])