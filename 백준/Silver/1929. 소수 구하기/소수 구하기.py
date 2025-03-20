import sys

input = lambda: sys.stdin.readline().rstrip()

MAX_VAL = 1000000


def eratos():
    is_prime = [True] * (MAX_VAL + 1)
    is_prime[1] = False

    for i in range(2, int((MAX_VAL + 1) ** 0.5) + 1):
        if is_prime[i]:
            for j in range(i**2, MAX_VAL + 1, i):
                is_prime[j] = False
    return is_prime


M, N = map(int, input().split())
is_prime = eratos()

result = []
for i in range(M, N + 1):
    if is_prime[i]:
        result.append(i)

print("\n".join(map(str, result)))
