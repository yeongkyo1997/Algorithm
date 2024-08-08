import copy

arr = list(map(int, input().split()))

tmp = copy.deepcopy(arr)

tmp.sort()
if arr == tmp:
    print('ascending')
elif arr == tmp[::-1]:
    print('descending')
else:
    print('mixed')