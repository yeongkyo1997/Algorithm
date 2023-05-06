import sys
from bisect import bisect_left

input = sys.stdin.readline


def lis(arr):
    lis_arr = [arr[0]]
    index_arr = [0]
    index = 1

    for num in arr[1:]:
        if lis_arr[-1] < num:
            lis_arr.append(num)
            index_arr.append(index)
            index += 1
        else:
            i = bisect_left(lis_arr, num)
            lis_arr[i] = num
            index_arr.append(i)

    return lis_arr, index_arr


def get_lis(arr, index_arr):
    ans = []
    idx = len(arr) - 1
    num = max(index_arr)

    while idx >= 0:
        if index_arr[idx] == num:
            ans.append(arr[idx])
            num -= 1
        idx -= 1

    return ans[::-1]


N = int(input())
nums = list(map(int, input().split()))

lis_arr, index_arr = lis(nums)
ans = get_lis(nums, index_arr)

print(len(ans))
print(*ans)