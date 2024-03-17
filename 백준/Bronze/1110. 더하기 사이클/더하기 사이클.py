import sys


def input(): return sys.stdin.readline().strip()


def solution(N):
    original = N
    result = 0
    while True:
        result += 1
        sum_of_digits = (N // 10) + (N % 10)
        N = (N % 10) * 10 + sum_of_digits % 10
        if N == original:
            break
    return result


N = int(input())

print(solution(N))