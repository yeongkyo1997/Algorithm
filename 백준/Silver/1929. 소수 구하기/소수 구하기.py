import sys


def input(): return sys.stdin.readline().rstrip()


def solutoin(M, N):
    if N < 2:
        return []

    num = int(N**0.5) + 1
    prime = [True] * num
    prime[0] = prime[1] = False

    for p in range(2, num):
        if prime[p]:
            for i in range(p * p, num, p):
                prime[i] = False

    result = [p for p in range(max(2, M), N + 1) if p % 2 != 0 and all(p %
                                                                       i != 0 for i in range(3, int(p**0.5) + 1, 2)) or p == 2]

    return result


M, N = map(int, input().split())
print(*solutoin(M, N), sep='\n')