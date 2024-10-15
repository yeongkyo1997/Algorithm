import sys


if __name__ == '__main__':
    N, L, W, H = map(int, input().split())

    left = 0
    right = max(L, W, H)

    for _ in range(1000):
        # 박스의 길이
        mid = (left + right) / 2

        cnt = (L // mid) * (W // mid) * (H // mid)

        if cnt >= N:
            left = mid + 1e-11
        else:
            right = mid - 1e-11

    print(left)