import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    for i in recursive(N):
        print(i)


def recursive(N):
    if N == 3:
        return ['***', '* *', '***']

    arr = recursive(N // 3)
    result = []

    for i in arr:
        result.append(i * 3)
    for i in arr:
        result.append(i + ' ' * (N // 3) + i)
    for i in arr:
        result.append(i * 3)

    return result


if __name__ == '__main__':
    main()