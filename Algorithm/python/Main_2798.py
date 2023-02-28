import itertools

N, M = map(int, input().split())

arr = map(int, input().split())
result = 0

for combi in itertools.combinations(arr, 3):
    cSum = sum(combi)

    if cSum <= M:
        result = max(result, cSum)

print(result)
