import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())

    for i in range(1, 10):
        print(f'{n} * {i} = {n * i}')


if __name__ == '__main__':
    main()
