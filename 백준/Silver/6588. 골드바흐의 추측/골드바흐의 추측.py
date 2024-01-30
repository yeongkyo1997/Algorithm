import sys


def input(): return sys.stdin.readline().rstrip()


MAX = 1000001
prime = [True] * MAX


prime[0] = prime[1] = False

for i in range(2, MAX):
    if prime[i]:
        for j in range(i * i, MAX, i):
            prime[j] = False


while True:
    n = int(input())
    if n == 0:
        break
    for i in range(2, MAX):
        if prime[i] and prime[n - i]:
            print(f'{n} = {i} + {n - i}')
            break