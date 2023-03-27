import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    n, k = map(int, input().split())
    arr = [0] * (n + 1)
    arr[0] = 1

def summation(n):
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
