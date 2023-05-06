import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    for i in range(int(input())):
        print(f'Case #{i + 1}: {sum(map(int, input().split()))}')


if __name__ == '__main__':
    main()