def solution(min_val, max_val):
    result = [True] * (max_val - min_val + 1)

    i = 2
    while i * i <= max_val:
        square = i * i
        start = ((min_val + square - 1) // square) * square
        for j in range(start, max_val + 1, square):
            result[j - min_val] = False
        i += 1

    return sum(result)


min_val, max_val = map(int, input().split())
results = solution(min_val, max_val)
print(results)