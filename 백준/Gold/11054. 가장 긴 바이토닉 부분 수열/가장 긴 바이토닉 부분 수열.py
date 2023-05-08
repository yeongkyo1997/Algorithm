def longest_bitonic_sequence(arr):
    n = len(arr)

    lis = [1] * n
    lds = [1] * n

    for i in range(1, n):
        for j in range(i):
            if arr[i] > arr[j] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1

    for i in range(n - 2, -1, -1):
        for j in range(n - 1, i, -1):
            if arr[i] > arr[j] and lds[i] < lds[j] + 1:
                lds[i] = lds[j] + 1

    max_length = 0
    for i in range(n):
        max_length = max(max_length, lis[i] + lds[i] - 1)

    return max_length


def main():
    N = int(input())
    A = list(map(int, input().split()))
    print(longest_bitonic_sequence(A))


if __name__ == "__main__":
    main()