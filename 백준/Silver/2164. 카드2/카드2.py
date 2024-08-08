import collections

N = int(input())

arr = collections.deque(range(1, N + 1))

while len(arr) > 1:
    arr.popleft()
    arr.rotate(-1)

print(arr.pop())