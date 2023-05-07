import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    K = int(input())
    a, b = 0, 0

    for _ in range(K):
        a, b = b, a + b if a + b else 1

    print(a, b)


if __name__ == '__main__':
    main()