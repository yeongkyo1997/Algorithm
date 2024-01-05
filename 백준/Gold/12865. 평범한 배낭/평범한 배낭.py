from functools import lru_cache

N, K = map(int, input().split())

items = [tuple(map(int, input().split())) for _ in range(N)]


@lru_cache(maxsize=None)
def max_value(index, capacity):
    if index == N or capacity == 0:
        return 0

    without_current_item = max_value(index + 1, capacity)

    weight, value = items[index]
    if weight <= capacity:
        with_current_item = value + max_value(index + 1, capacity - weight)
    else:
        with_current_item = 0

    return max(without_current_item, with_current_item)


result = max_value(0, K)
print(result)