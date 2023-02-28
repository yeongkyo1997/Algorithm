import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 1874 스택 수열
def main():
    N = int(input())
    stack = []
    arr = []
    cnt = 1
    result = []

    for i in range(N):
        arr.append(int(input()))

    for i in arr:
        while cnt <= i:
            stack.append(cnt)
            cnt += 1
            result.append('+')

        if stack[-1] == i:
            stack.pop()
            result.append('-')
        else:
            print('NO')
            return

    for i in result:
        print(i)


if __name__ == '__main__':
    main()
