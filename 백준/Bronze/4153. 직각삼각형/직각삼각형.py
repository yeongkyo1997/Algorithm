import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        a, b, c = map(int, input().split())
        if not a and not b and not c:
            break
        if a ** 2 + b ** 2 == c ** 2 or a ** 2 + c ** 2 == b ** 2 or b ** 2 + c ** 2 == a ** 2:
            print('right')
        else:
            print('wrong')


if __name__ == '__main__':
    main()