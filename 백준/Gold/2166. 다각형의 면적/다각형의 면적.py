import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == "__main__":
    N = int(input())
    points = []
    idx = 1
    for _ in range(N):
        x, y = map(int, input().split())
        points.append((x, y))
        idx += 2

    # 슈어츠 공식 적용
    shoelace = 0
    for i in range(N):
        x1, y1 = points[i]
        x2, y2 = points[(i + 1) % N]  # 마지막 정점과 첫 번째 정점 연결
        shoelace += (x1 * y2) - (x2 * y1)

    area = abs(shoelace) / 2

    # 소수점 첫째 자리까지 반올림하여 출력
    print(f"{area:.1f}")