import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    a, b = map(int, input().split())
    print(f"{a / b:.10f}")


if __name__ == '__main__':
    main()
