def count_pairs_with_sum(arr, x):
    count = 0
    seen = {}

    for number in arr:
        target = x - number
        if target in seen:
            count += 1
        seen[number] = True

    return count


n = int(input())
arr = list(map(int, input().rstrip().split()))
x = int(input())

print(count_pairs_with_sum(arr, x))