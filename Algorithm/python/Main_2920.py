arr = list(map(int, input().split()))
ascending = sorted(arr)
descending = sorted(arr, reverse=True)

if all([a == b for a, b in zip(arr, ascending)]):
    print('ascending')

elif all([a == b for a, b in zip(arr, descending)]):
    print('descending')
else:
    print('mixed')
