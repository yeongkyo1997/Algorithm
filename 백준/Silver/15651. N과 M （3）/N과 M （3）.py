import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())


def solution(arr, start, depth):
    if depth == M:
        print(*arr)
        return

    for i in range(start, N + 1):
        arr.append(i)
        solution(arr, start, depth + 1)
        arr.pop()


solution([], 1, 0)