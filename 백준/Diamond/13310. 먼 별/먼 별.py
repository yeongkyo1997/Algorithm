import math


def ccw(a, b, c):
    res = (a[0] * b[1]) + (b[0] * c[1]) + (c[0] * a[1])
    res -= (b[0] * a[1]) + (c[0] * b[1]) + (a[0] * c[1])
    return 1 if res > 0 else -1 if res < 0 else 0


def dist(a, b):
    dx = a[0] - b[0]
    dy = a[1] - b[1]
    return dx * dx + dy * dy


def check(s, e, ss, ee):
    t = (e[0] - s[0], e[1] - s[1])
    tt = (ee[0] - ss[0], ee[1] - ss[1])
    return ccw((0, 0), t, tt) >= 0


def f(t):
    for i in range(n):
        arr[i] = (v[i].x + v[i].dx * t, v[i].y + v[i].dy * t)

    leftmost_bottom = min(arr)
    arr.remove(leftmost_bottom)
    arr.insert(0, leftmost_bottom)

    arr[1:] = sorted(arr[1:], key=lambda p: (ccw(arr[0], p, arr[1]) > 0, dist(arr[0], p)))

    hull = []
    for i in range(n):
        while len(hull) >= 2 and ccw(hull[-2], hull[-1], arr[i]) <= 0:
            hull.pop()
        hull.append(arr[i])

    ret = 0
    p = 0
    for i in range(len(hull)):
        while p + 1 < len(hull) and check(hull[i], hull[(i + 1) % len(hull)], hull[p], hull[(p + 1) % len(hull)]):
            ret = max(ret, dist(hull[i], hull[p]))
            p += 1
        ret = max(ret, dist(hull[i], hull[p]))

    return ret


n, t = map(int, input().split())


class Star:
    def __init__(self, x, y, dx, dy):
        self.x = x
        self.y = y
        self.dx = dx
        self.dy = dy

    def get(self):
        self.x, self.y, self.dx, self.dy = map(int, input().split())


v = [Star(0, 0, 0, 0) for _ in range(n)]
arr = [(0, 0) for _ in range(n)]
for i in range(n):
    v[i].get()

start, end = 0, t
while start + 3 <= end:
    left = (2 * start + end) // 3
    right = (start + 2 * end) // 3
    if f(left) > f(right):
        start = left
    else:
        end = right

result = math.inf
idx = start
for i in range(start, end + 1):
    now = f(i)
    if result > now:
        result = now
        idx = i

print(idx)
print(result)