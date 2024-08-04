N = int(input())
arr = list(map(int, input().rstrip().split()))
arr.sort()


def binary_search(left, right, num):
    while left <= right:
        mid = (left + right) // 2
        if num > arr[mid]:
            left = mid + 1
        elif num < arr[mid]:
            right = mid - 1
        else:
            return 1

    return 0


input()
for ele in map(int, input().rstrip().split()):
    print(binary_search(0, len(arr) - 1, ele))