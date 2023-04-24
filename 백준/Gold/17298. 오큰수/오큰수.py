import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = list(map(int, input().split()))
    stack = []

    for i in range(N):
        while stack and arr[stack[-1]] < arr[i]:
            arr[stack.pop()] = arr[i]
        stack.append(i)

    while stack:
        arr[stack.pop()] = -1

    print(*arr)


if __name__ == '__main__':
    main()