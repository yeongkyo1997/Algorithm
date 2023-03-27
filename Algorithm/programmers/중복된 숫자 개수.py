def solution(array, n):
    return len(list(filter(lambda x: x == n, array)))


array = [1, 1, 2, 3, 4, 5]
N = 1
print(solution(array, N))
