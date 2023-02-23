import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    a, b = map(int, input().split())
    if a > b:
        print('>')
    elif a < b:
        print('<')
    else:
        print('==')


if __name__ == '__main__':
    main()