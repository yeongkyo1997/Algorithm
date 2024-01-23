def next_permutations(arr):
    i = len(arr) - 2

    while i >= 0 and arr[i] >= arr[i + 1]:
        i -= 1
    pivot = i

    if pivot < 0:
        return [-1]

    j = len(arr) - 1

    while j >= 0 and arr[pivot] >= arr[j]:
        j -= 1

    arr[j], arr[pivot] = arr[pivot], arr[j]

    arr[pivot + 1:] = reversed(arr[pivot + 1:])

    return arr


input()
print(*next_permutations(list(map(int, input().split()))))