import functools
import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    T = int(input())

@functools.cache
def summation(n, k):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return summation(n - 1) + summation(n - 2) + summation(n - 3)

if __name__ == '__main__':
    main()
