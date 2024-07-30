def solve(N, M, positions):
    # 책의 위치를 음수와 양수로 분리
    neg_pos = sorted([pos for pos in positions if pos < 0], key=abs, reverse=True)
    pos_pos = sorted([pos for pos in positions if pos > 0], key=abs, reverse=True)

    def get_dist(positions):
        distance = 0
        for i in range(0, len(positions), M):
            distance += 2 * abs(positions[i])
        return distance

    # 양수와 음수 위치에서 각각 최소 걸음 수 계산
    neg_dist = get_dist(neg_pos)
    pos_dist = get_dist(pos_pos)

    # 가장 먼 책의 위치를 구해서 마지막 이동 거리를 편도로 처리
    max_dist = 0
    if neg_pos:
        max_dist = max(max_dist, abs(neg_pos[0]))
    if pos_pos:
        max_dist = max(max_dist, abs(pos_pos[0]))

    # 전체 거리에서 가장 먼 책의 위치를 한 번 빼줌
    total = neg_dist + pos_dist - max_dist

    return total


# 입력 처리
N, M = map(int, input().split())
arr = list(map(int, input().split()))

# 결과 출력
print(solve(N, M, arr))