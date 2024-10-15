if __name__ == '__main__':
    N, M, L = map(int, input().split())
    S = [int(input()) for _ in range(M)]
    Q = [int(input()) for _ in range(N)]

    results = []
    for q in Q:
        start = 1
        end = L

        max_val = 0
        while start <= end:
            # 가장 작은 조각의 최대 길이
            mid = start + end >> 1
            # 잘린 단면의 지점(최근 cm)
            cur = 0
            cnt = 0
            for s in S + [L]:
                if s - cur >= mid:
                    cnt += 1
                    cur = s

            if cnt > q:
                start = mid + 1
                # max_val = max(max_val, mid)
                max_val = mid
            else:
                end = mid - 1

        results.append(max_val)

    print('\n'.join(map(str, results)))