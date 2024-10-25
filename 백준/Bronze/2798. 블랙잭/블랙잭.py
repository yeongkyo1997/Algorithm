import itertools

if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    result = 0
    for comb in itertools.combinations(arr, 3):
        total = sum(comb)

        if total <= M:
            result = max(total, result)

    print(result)