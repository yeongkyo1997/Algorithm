import sys
from collections import deque


input = sys.stdin.readline

n, m, c = map(int, input().split())
a = list(map(int, input().split()))

min_dq = deque()
max_dq = deque()
result_indices = []
found_silence = False

for i in range(n):
    current_val = a[i]
    current_idx = i

    while min_dq and min_dq[-1][0] >= current_val:
        min_dq.pop()
    min_dq.append((current_val, current_idx))

    while max_dq and max_dq[-1][0] <= current_val:
        max_dq.pop()
    max_dq.append((current_val, current_idx))

    window_start_index = i - m + 1

    if min_dq[0][1] < window_start_index:
        min_dq.popleft()

    if max_dq[0][1] < window_start_index:
        max_dq.popleft()

    if i >= m - 1:
        current_min = min_dq[0][0]
        current_max = max_dq[0][0]

        if current_max - current_min <= c:
            result_indices.append(window_start_index)
            found_silence = True


if not found_silence:
    print("NONE")
else:
    for index in result_indices:
        print(index + 1)
