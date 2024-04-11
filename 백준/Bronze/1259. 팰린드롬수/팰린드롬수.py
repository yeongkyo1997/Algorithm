import sys


def input(): return sys.stdin.readline().rstrip()


def num_reverse(n):
    result = 0

    while True:
        result += n % 10
        n //= 10

        if n == 0:
            break
        result *= 10

    return result


while True:
    n = int(input())
    if n == 0:
        break

    if n == num_reverse(n):
        print('yes')
    else:
        print('no')