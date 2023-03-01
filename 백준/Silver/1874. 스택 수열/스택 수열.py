import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    stack = []
    arr = []

    n = int(input())
    for i in range(n):
        arr.append(int(input()))

    idx = 0
    result = ''
    for i in range(1, n + 1):
        stack.append(i)
        result += '+\n'

        while stack and stack[-1] == arr[idx]:
            stack.pop()
            result += '-\n'
            idx += 1

    if stack:
        print('NO')
    else:
        print(result)


if __name__ == '__main__':
    main()