def calculate_distance(point1, point2):
    return abs(point1[0] - point2[0]) + abs(point1[1] - point2[1])


def find_shortest_route(num_customers, coordinates):
    company = coordinates[0]
    home = coordinates[1]
    customers = coordinates[2:]

    min_distance = float('inf')

    def permute(path, visited, current_distance):
        nonlocal min_distance

        # 모든 고객을 방문한 경우, 집으로 돌아가는 거리 추가
        if len(path) == num_customers:
            total_distance = current_distance + calculate_distance(customers[path[-1]], home)
            min_distance = min(min_distance, total_distance)
            return

        # 각 고객을 방문하는 순서를 생성
        for i in range(num_customers):
            if not visited[i]:
                visited[i] = True
                next_distance = current_distance + calculate_distance(customers[path[-1]],
                                                                      customers[i]) if path else calculate_distance(
                    company, customers[i])
                permute(path + [i], visited, next_distance)
                visited[i] = False

    # 방문 순서 생성 시작
    permute([], [False] * num_customers, 0)

    return min_distance


# 테스트 케이스 입력
test_cases = [
    (5, [(0, 0), (100, 100), (70, 40), (30, 10), (10, 5), (90, 70), (50, 20)]),
    (6, [(88, 81), (85, 80), (19, 22), (31, 15), (27, 29), (30, 10), (20, 26), (5, 14)]),
    (7, [(22, 47), (72, 42), (61, 93), (8, 31), (72, 54), (0, 64), (26, 71), (93, 87), (84, 83)]),
    (8, [(30, 20), (43, 14), (58, 5), (91, 51), (55, 87), (40, 91), (14, 55), (28, 80), (75, 24), (74, 63)]),
    (9, [(3, 9), (100, 100), (16, 52), (18, 19), (35, 67), (42, 29), (47, 68), (59, 38), (68, 81), (80, 37), (94, 92)]),
    (10, [(39, 9), (97, 61), (35, 93), (62, 64), (96, 39), (36, 36), (9, 59), (59, 96), (61, 7), (64, 43), (43, 58),
          (1, 36)]),
    (10, [(26, 100), (72, 2), (71, 100), (29, 48), (74, 51), (27, 0), (58, 0), (35, 2), (43, 47), (50, 49), (44, 100),
          (66, 96)]),
    (10, [(46, 25), (16, 6), (48, 82), (80, 21), (49, 34), (60, 25), (93, 90), (26, 96), (12, 100), (44, 69), (28, 15),
          (57, 63)]),
    (10, [(94, 83), (72, 42), (43, 36), (59, 44), (52, 57), (34, 49), (65, 79), (14, 20), (41, 9), (0, 39), (100, 94),
          (53, 3)]),
    (10, [(32, 79), (0, 0), (69, 58), (100, 31), (67, 67), (58, 66), (83, 22), (44, 24), (68, 3), (76, 85), (63, 87),
          (7, 86)])
]

for t in range(1, int(input()) + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    points = []
    for i in range(len(arr)):
        if i % 2 != 0:
            points.append((arr[i - 1], arr[i]))
    result = find_shortest_route(N, points)
    print(f'#{t} {result}')
