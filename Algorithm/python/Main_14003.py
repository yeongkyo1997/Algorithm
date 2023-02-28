import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    dp = [arr[0]]
    idx = [0]
    for i in range(1, n):
        if arr[i] > dp[-1]:
            dp.append(arr[i])
            idx.append(len(dp) - 1)
        else:
            left = 0
            right = len(dp) - 1
            while left < right:
                mid = (left + right) // 2
                if dp[mid] < arr[i]:
                    left = mid + 1
                else:
                    right = mid
            dp[left] = arr[i]
            idx.append(left)

    print(len(dp))
    stack = []
    for i in range(len(idx) - 1, -1, -1):
        if idx[i] == len(dp) - 1:
            stack.append(arr[i])
            dp.pop()
        if not dp:
            break
    while stack:
        print(stack.pop(), end=' ')
    print()


if __name__ == '__main__':
    main()
