import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    i = 1
    while True:
        if n <= 1 + 3 * (i - 1) * i:
            print(i)
            break
        i += 1


if __name__ == '__main__':
    main()