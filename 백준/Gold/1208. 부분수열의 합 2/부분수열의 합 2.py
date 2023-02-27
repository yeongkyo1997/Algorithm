import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, S = map(int, input().split())
    A = list(map(int, input().split()))
    left = A[:N // 2]
    right = A[N // 2:]
    left_sum = []
    right_sum = []
    for i in range(1 << len(left)):
        temp = 0
        for j in range(len(left)):
            if i & (1 << j):
                temp += left[j]
        left_sum.append(temp)
    for i in range(1 << len(right)):
        temp = 0
        for j in range(len(right)):
            if i & (1 << j):
                temp += right[j]
        right_sum.append(temp)
    left_sum.sort()
    right_sum.sort(reverse=True)
    left_idx = 0
    right_idx = 0
    result = 0
    while left_idx < len(left_sum) and right_idx < len(right_sum):
        if left_sum[left_idx] + right_sum[right_idx] == S:
            left_cnt = 1
            right_cnt = 1
            left_idx += 1
            right_idx += 1
            while left_idx < len(left_sum) and left_sum[left_idx] == left_sum[left_idx - 1]:
                left_cnt += 1
                left_idx += 1
            while right_idx < len(right_sum) and right_sum[right_idx] == right_sum[right_idx - 1]:
                right_cnt += 1
                right_idx += 1
            result += left_cnt * right_cnt
        elif left_sum[left_idx] + right_sum[right_idx] < S:
            left_idx += 1
        else:
            right_idx += 1
    if S == 0:
        result -= 1
    print(result)

if __name__ == '__main__':
    main()