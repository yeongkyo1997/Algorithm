import collections

for _ in range(10):
    t = int(input())
    arr = collections.deque(map(int, input().split()))

    minus = 1
    while arr[-1] != 0:
        arr.append(max(arr.popleft() - minus, 0))
        minus += 1
        if minus > 5:
            minus = 1

    print(f'#{t} ', end='')
    print(*arr)
