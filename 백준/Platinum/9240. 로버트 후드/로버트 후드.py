import sys
import math

input = lambda: sys.stdin.readline().rstrip()


def cross(o, a, b):
    return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])


def convex_hull(points):
    points = sorted(points)
    lower = []
    for p in points:
        while len(lower) >= 2 and cross(lower[-2], lower[-1], p) <= 0:
            lower.pop()
        lower.append(p)
    upper = []
    for p in reversed(points):
        while len(upper) >= 2 and cross(upper[-2], upper[-1], p) <= 0:
            upper.pop()
        upper.append(p)
    return lower[:-1] + upper[:-1]


def distance(p1, p2):
    return math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)


def get_dist(points):
    hull = convex_hull(points)
    n = len(hull)
    if n < 2:
        return 0

    max_dist = 0
    for i in range(n):
        for j in range(i + 1, n):
            max_dist = max(max_dist, distance(hull[i], hull[j]))
    return max_dist


C = int(input())
points = [tuple(map(int, input().split())) for _ in range(C)]
print(f"{get_dist(points):.10f}")