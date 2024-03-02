import sys
def input(): return sys.stdin.readline().rstrip()


def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True


def solution(N, num, depth):
    if depth == N:
        if is_prime(num):
            print(num)
        return

    start = 1 if depth == 0 else 0
    for i in range(start, 10):
        tmp = num * 10 + i
        if is_prime(tmp):
            solution(N, tmp, depth + 1)


N = int(input())
solution(N, 0, 0)