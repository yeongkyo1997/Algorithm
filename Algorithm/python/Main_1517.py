import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = list(map(int, input().split()))
    print(mergeSort(arr))


def mergeSort(arr):
    if len(arr) == 1:
        return 0

    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    result = mergeSort(left) + mergeSort(right)
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            arr[i + j] = left[i]
            i += 1
        else:
            arr[i + j] = right[j]
            j += 1
            result += len(left) - i

    while i < len(left):
        arr[i + j] = left[i]
        i += 1

    while j < len(right):
        arr[i + j] = right[j]
        j += 1

    return result


if __name__ == '__main__':
    main()
