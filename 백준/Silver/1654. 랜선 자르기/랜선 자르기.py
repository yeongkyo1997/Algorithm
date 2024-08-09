K, N = map(int, input().split())

arr = [int(input()) for _ in range(K)]


def binary_search(start, end):
    while start <= end:
        mid = (start + end) // 2
        lines = 0

        for i in arr:
            lines += i // mid

        if lines >= N:
            start = mid + 1
        else:
            end = mid - 1

    return end


print(binary_search(1, 2 ** 32))