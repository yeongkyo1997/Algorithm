import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = [0]
    for i in range(N):
        arr.append(int(input()))
    arr.append(0)
    stack = [0]
    result = 0

    for i in range(1, N + 2):
        while arr[stack[-1]] > arr[i]:
            height = arr[stack.pop()]
            width = i - stack[-1] - 1
            result = max(result, height * width)
        stack.append(i)

    print(result)


if __name__ == '__main__':
    main()
