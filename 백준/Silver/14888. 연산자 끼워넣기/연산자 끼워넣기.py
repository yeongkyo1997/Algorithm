import sys

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


N = int(input())
a = list(map(int, input().split()))

symbol = list(map(int, input().split()))


def solution(total, depth):
    global MIN, MAX
    if depth == N:
        MIN = min(MIN, total)
        MAX = max(MAX, total)
        return

    for i in range(4):
        if symbol[i] > 0:
            symbol[i] -= 1
        else:
            continue
        if i == 0:
            solution(total + a[depth], depth + 1)
        elif i == 1:
            solution(total - a[depth], depth + 1)
        elif i == 2:
            solution(total * a[depth], depth + 1)
        else:
            solution(int(total / a[depth]), depth + 1)
        symbol[i] += 1


MIN = float('inf')
MAX = float('-inf')

solution(a[0], 1)

print(MAX)
print(MIN)