N, K = map(int, input().split())

items = [tuple(map(int, input().split())) for _ in range(N)]

memo = [[-1 for _ in range(K + 1)] for _ in range(N + 1)]


def max_value(index, capacity):
    if index == 0 or capacity == 0:
        return 0

    if memo[index][capacity] != -1:
        return memo[index][capacity]

    without_current_item = max_value(index - 1, capacity)

    weight, value = items[index - 1]
    if weight <= capacity:
        with_current_item = value + max_value(index - 1, capacity - weight)
    else:
        with_current_item = 0

    memo[index][capacity] = max(without_current_item, with_current_item)
    return memo[index][capacity]


result = max_value(N, K)
print(result)