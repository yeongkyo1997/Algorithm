import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def solve(n):
    res = 1
    if n == 0:
        return 1

    for i in range(1, n + 1):
        res *= i

    return res


result = 0
print('n e')
print('- -----------')

for i in range(10):
    result += 1 / math.factorial(i)
    if result > 2.5:
        print(f'{i} {result:0.9f}')
    elif result == 1 or result == 2:
        print(f'{i} {result:0.0f}')
    elif result == 2.5:
        print(f'{i} {result:0.1f}')