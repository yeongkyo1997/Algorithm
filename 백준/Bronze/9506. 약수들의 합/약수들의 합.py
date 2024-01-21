import sys


def input(): return sys.stdin.readline().rstrip()


def get_factor(n):
    result = set()
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            result.add(i)
            result.add(n // i)
    return sorted(result)


while True:
    n = int(input())

    if n == -1:
        break

    factor = get_factor(n)

    if sum(factor) - n == n:
        print(f'{n} = {" + ".join(map(str, factor[:-1]))}')
    else:
        print(f'{n} is NOT perfect.')