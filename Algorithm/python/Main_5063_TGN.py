import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    for _ in range(n):
        r, e, c = map(int, input().split())
        if r < e - c:
            print('advertise')
        elif r == e - c:
            print('does not matter')
        else:
            print('do not advertise')


if __name__ == '__main__':
    main()
