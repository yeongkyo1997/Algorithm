import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    try:
        while True:
            a, b = map(int, input().split())
            print(a + b)
    except:
        return


if __name__ == '__main__':
    main()