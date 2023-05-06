import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    for i in range(int(input())):
        a, b = map(int, input().split())
        print(f'Case #{i + 1}: {a} + {b} = {a + b}')


if __name__ == '__main__':
    main()