def count_unhappy_cows(N, c):
    # 이동 가능한 범위를 계산합니다.
    ranges = [(i-c[i], i) for i in range(N)]
    ranges.sort()

    # visited[i]가 True이면 i번째 소는 선물을 받을 수 있습니다.
    visited = [False] * N

    # 각 소를 시작점으로 해서 이동 가능한 모든 소들에 대해 visited를 True로 설정합니다.
    for i in range(N):
        if visited[i]:
            continue
        start, end = ranges[i]
        for j in range(start, end+1):
            visited[j] = True

    # visited[i]가 False인 경우, i번째 소는 선물을 받을 수 없습니다.
    return sum(1 for v in visited if not v)

# 입력을 받습니다.
N = int(input())
c = list(map(int, input().split()))

# 선물을 받을 수 없는 소의 수를 계산합니다.
unhappy_cows = count_unhappy_cows(N, c)

# 결과를 출력합니다.
print(unhappy_cows)
