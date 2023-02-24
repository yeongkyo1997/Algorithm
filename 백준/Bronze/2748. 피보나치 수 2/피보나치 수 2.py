import functools
import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n = int(input())
    print(fibo(n))

@functools.cache
def fibo(n):
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    return fibo(n - 1) + fibo(n - 2)

if __name__ == '__main__':
    main()