import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = list(map(int, input().split()))

    arr.sort()

    M = int(input())
    arr2 = list(map(int, input().split()))

    for i in range(M):
        left = 0
        right = N - 1
        while left <= right:
            mid = (left + right) // 2
            if arr[mid] == arr2[i]:
                print(1)
                break
            elif arr[mid] > arr2[i]:
                right = mid - 1
            else:
                left = mid + 1
        else:
            print(0)

if __name__ == '__main__':
    main()
