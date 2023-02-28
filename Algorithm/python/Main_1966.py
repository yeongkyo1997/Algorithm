import collections

for _ in range(int(input())):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    queue = collections.deque()

    for i in arr:
        queue.append(i)

    cnt = 0
    while queue:
        if queue[0] == max(queue):
            cnt += 1
            queue.popleft()
            m -= 1
            if m == -1:
                print(cnt)
                break
        else:
            queue.append(queue.popleft())
            m -= 1
            if m == -1:
                m = len(queue) - 1
