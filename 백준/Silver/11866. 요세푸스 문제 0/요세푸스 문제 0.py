import collections

N, K = map(int, input().split())

print('<', end='')

arr = collections.deque(range(1, N + 1))

result = []

while arr:
    arr.rotate(-(K - 1))
    result.append(arr.popleft())

print(*result, sep=', ',end='')
print('>')