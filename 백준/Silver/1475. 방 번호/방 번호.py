from collections import Counter
import math
import sys


def input(): return sys.stdin.readline().rstrip()


N = input().replace('6', '9')
lib = Counter(N)
lib['9'] = round(math.ceil(lib['9'] / 2))
print(max(lib.values()))