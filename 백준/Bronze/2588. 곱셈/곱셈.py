import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    a = int(input())
    b = int(input())
    multi = a * b
    print(a * (b % 10))
    b //= 10
    print(a * (b % 10))
    b //= 10
    print(a * (b % 10))
    print(multi)


if __name__ == '__main__':
    main()