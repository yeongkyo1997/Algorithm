import collections

T = int(input())


def is_first(x):
    for i in range(N):
        if i == x:
            continue

        if priority[x] < priority[i]:
            return False

    return True


for _ in range(T):
    cnt = 0
    N, M = map(int, input().split())
    priority = list(map(int, input().split()))
    q = collections.deque(range(N))

    while q:
        x = q[0]
        if is_first(x):
            priority[x] = 0
            q.popleft()
            cnt += 1
            if x == M:
                break
        else:
            q.rotate(-1)
    print(cnt)
