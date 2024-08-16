import sys
from bisect import bisect_left

input = lambda: sys.stdin.readline().rstrip()


def lis_with_sequence(arr):
    n = len(arr)
    lis = []
    predecessors = [-1] * n  # 이전 원소의 인덱스를 저장
    lis_indices = []  # lis의 인덱스를 저장

    for i, num in enumerate(arr):
        pos = bisect_left(lis, num)
        if pos == len(lis):
            lis.append(num)
            lis_indices.append(i)
        else:
            lis[pos] = num
            lis_indices[pos] = i

        if pos > 0:
            predecessors[i] = lis_indices[pos - 1]

    # LIS 수열 복원
    lis_length = len(lis)
    lis_sequence = []
    k = lis_indices[-1]
    for _ in range(lis_length):
        lis_sequence.append(arr[k])
        k = predecessors[k]
    lis_sequence.reverse()

    return lis_length, lis_sequence


# 입력 예시
n = int(input())
arr = list(map(int, input().split()))
length, sequence = lis_with_sequence(arr)
print(length)  # 출력: 4
print(' '.join(map(str, sequence)))  # 출력: 10 20 30 50