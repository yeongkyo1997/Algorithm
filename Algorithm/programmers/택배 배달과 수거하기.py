# 트럭에 실을 수 있는 재활용 택배 상자의 최대 개수를 나타내는 정수 cap
# 배달할 집의 개수를 나타내는 정수 n
# 각 집에 배달할 재활용 택배 상자의 개수를 담은 1차원 정수 배열 deliveries
# 각 집에서 수거할 빈 재활용 택배 상자의 개수를 담은 1차원 정수 배열 pickups

def solution(cap, n, deliveries, pickups):
    result = 0
    s1, s2 = [], []
    for idx, a, b in enumerate(zip(deliveries, pickups)):
        s1.append((idx + 1, a))
        s2.append((idx + 1, b))

    while True:
        # 가능한 적재량
        cur = cap
