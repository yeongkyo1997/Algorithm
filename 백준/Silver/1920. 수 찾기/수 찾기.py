def binary_search(x):
    start = 0
    end = N - 1

    while start <= end:
        mid = start + end >> 1

        if arr[mid] == x:
            return 1
        elif arr[mid] > x:
            end = mid - 1
        else:
            start = mid + 1
    return 0


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    M = int(input())

    for a in list(map(int, input().split())):
        print(binary_search(a))