import sys

input = sys.stdin.readline


MAX_VAL = 65536


bit = [0] * MAX_VAL


def update(i, delta):
    """Updates the Fenwick tree by adding delta to index i."""

    while i < MAX_VAL:
        bit[i] += delta

        i += i & (-i)


def find_kth(k):
    """Finds the 1-based index corresponding to the k-th element in the BIT."""

    pos = 0

    cumulative_sum = 0

    for p in range(15, -1, -1):
        step = 1 << p
        new_pos = pos + step

        if new_pos < MAX_VAL:

            if cumulative_sum + bit[new_pos] < k:

                cumulative_sum += bit[new_pos]
                pos = new_pos

    return pos + 1


N, K = map(int, input().split())

temps = [int(input()) for _ in range(N)]


median_rank = (K + 1) // 2

total_median_sum = 0


for i in range(K):

    update(temps[i] + 1, 1)


first_median_value = find_kth(median_rank) - 1
total_median_sum += first_median_value


for i in range(K, N):

    leaving_value = temps[i - K]

    entering_value = temps[i]

    update(leaving_value + 1, -1)

    update(entering_value + 1, 1)

    current_median_value = find_kth(median_rank) - 1
    total_median_sum += current_median_value


print(total_median_sum)
