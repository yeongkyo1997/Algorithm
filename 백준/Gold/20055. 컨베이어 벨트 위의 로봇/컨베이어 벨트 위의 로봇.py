import collections

N, K = map(int, input().split())
A = collections.deque(map(int, input().split()))
belt = collections.deque([False] * N, maxlen=N)

result = 0
while True:
    result += 1
    A.rotate(1)
    belt.rotate(1)

    belt[N - 1] = False

    for i in range(N - 2, -1, -1):
        if belt[i] and not belt[i + 1] and A[i + 1] > 0:
            belt[i], belt[i + 1] = False, True
            A[i + 1] -= 1

    belt[N - 1] = False

    if A[0] > 0:
        belt[0] = True
        A[0] -= 1

    if A.count(0) >= K:
        break

print(result)