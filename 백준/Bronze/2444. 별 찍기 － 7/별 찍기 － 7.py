N = int(input())
for i in range(1, N * 2):
    if i <= N:  # 위쪽 부분
        print(' ' * (N - i) + '*' * (2 * i - 1))
    else:  # 아래쪽 부분
        print(' ' * (i - N) + '*' * (2 * (2 * N - i) - 1))