from itertools import permutations
import sys


def input(): return sys.stdin.readline().rstrip()


for i in permutations(range(1, int(input()) + 1)):
    print(*i)