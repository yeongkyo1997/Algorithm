import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    arr = [int(input()) for i in range(9)]
    arr = list(itertools.combinations(arr, 7))
    for i in arr:
        if sum(i) == 100:
            [print(x) for x in sorted(i)]
            return


if __name__ == '__main__':
    main()
