import math
import random
import sys

sys.setrecursionlimit(10 ** 5)


# 원을 표현하는 클래스
class Circle:
    def __init__(self, center=(0.0, 0.0), radius=0.0):
        self.x, self.y = center
        self.r = radius


# 두 점 사이의 거리 계산
def distance(p1, p2):
    return math.hypot(p1[0] - p2[0], p1[1] - p2[1])


# 원 안에 점이 있는지 확인
def is_in_circle(c, p):
    return distance((c.x, c.y), p) <= c.r + 1e-12


# 두 점을 지나는 최소 원
def circle_two_points(p1, p2):
    center = ((p1[0] + p2[0]) / 2.0, (p1[1] + p2[1]) / 2.0)
    radius = distance(p1, p2) / 2.0
    return Circle(center, radius)


# 세 점을 지나는 원 (외접원)
def circle_three_points(p1, p2, p3):
    # 계산을 단순화하기 위해 좌표를 재배열
    A = p2[0] - p1[0]
    B = p2[1] - p1[1]
    C = p3[0] - p1[0]
    D = p3[1] - p1[1]
    E = A * (p1[0] + p2[0]) + B * (p1[1] + p2[1])
    F = C * (p1[0] + p3[0]) + D * (p1[1] + p3[1])
    G = 2.0 * (A * (p3[1] - p2[1]) - B * (p3[0] - p2[0]))

    if G == 0:
        # 세 점이 일직선 상에 있는 경우, 가장 먼 두 점을 연결하는 원
        c1 = circle_two_points(p1, p2)
        c2 = circle_two_points(p1, p3)
        c3 = circle_two_points(p2, p3)
        # 반지름이 가장 큰 원을 반환
        if c1.r >= c2.r and c1.r >= c3.r:
            return c1
        elif c2.r >= c1.r and c2.r >= c3.r:
            return c2
        else:
            return c3
    else:
        cx = (D * E - B * F) / G
        cy = (A * F - C * E) / G
        center = (cx, cy)
        radius = distance(center, p1)
        return Circle(center, radius)


# 최소 외접원 알고리즘 (Welzl's algorithm)
def welzl(points, boundary):
    if not points or len(boundary) == 3:
        if len(boundary) == 0:
            return Circle((0.0, 0.0), 0.0)
        elif len(boundary) == 1:
            return Circle(boundary[0], 0.0)
        elif len(boundary) == 2:
            return circle_two_points(boundary[0], boundary[1])
        else:
            return circle_three_points(boundary[0], boundary[1], boundary[2])

    p = points.pop()
    c = welzl(points, boundary)

    if is_in_circle(c, p):
        points.append(p)
        return c
    else:
        boundary.append(p)
        c_new = welzl(points, boundary)
        boundary.pop()
        points.append(p)
        return c_new


def minimal_enclosing_circle(points):
    shuffled = points[:]
    random.shuffle(shuffled)
    return welzl(shuffled, [])


def main():
    N = int(input())
    points = []
    for i in range(N):
        x, y = map(int, input().split())
        points.append((x, y))

    mec = minimal_enclosing_circle(points)

    print("{0:.3f} {1:.3f}".format(mec.x, mec.y))
    print("{0:.3f}".format(mec.r))


if __name__ == "__main__":
    main()
