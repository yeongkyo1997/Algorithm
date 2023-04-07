import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    factory = list(map(int, input().split()))

    rest_cnt = len(list(filter(lambda x: x != 0, factory)))
    result = 0

    idx = 0
    while idx < n:

        if factory[idx] == 0:
            idx += 1
            continue

        factory[idx] -= 1
        if factory[idx] == 0:
            rest_cnt -= 1

        if idx < n - 1 and factory[idx + 1] != 0 and factory[idx] + 1 <= factory[idx + 1]:
            factory[idx + 1] -= 1
            if factory[idx + 1] == 0:
                rest_cnt -= 1

            if idx < n - 2 and factory[idx + 2] != 0 and factory[idx + 1] + 1 <= factory[idx + 2]:
                factory[idx + 2] -= 1
                if factory[idx + 2] == 0:
                    rest_cnt -= 1
                result += 7
            else:
                result += 5
        else:
            result += 3

    print(result)


if __name__ == '__main__':
    main()