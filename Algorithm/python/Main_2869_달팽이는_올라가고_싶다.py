import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    A, B, V = map(int, input().split())
    day = (V - B - 1) // (A - B) + 1
    print(day)


if __name__ == '__main__':
    main()
