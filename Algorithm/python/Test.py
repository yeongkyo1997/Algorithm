import collections

arr = [1, [2, [3, [4, 5]]]]
tmp = []
arr1 = collections.deque()


# [1, [2, [3, [4, 5]]]] to [[[[5, 4], 3], 2], 1]
def reverse(arr):
    if len(arr) == 1:
        return arr[0]
    else:
        tmp = [reverse(arr[1:]), arr[0]]
        return tmp


print(reverse(arr))