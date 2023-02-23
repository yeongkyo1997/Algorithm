import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    str = input()
    str += '??!'
    print(str)


if __name__ == '__main__':
    main()