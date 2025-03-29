import sys


def solve():

    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())

    points = []

    for _ in range(m):
        li, ri = map(int, sys.stdin.readline().split())

        if li + ri <= n:

            points.append((li, 1))

            points.append((n - ri + 1, -1))

    if not points:
        print(f"1 {n - 1}")
        return

    points.sort(key=lambda x: (x[0], -x[1]))

    max_count = 0
    current_count = 0

    best_L = 1

    prev_coord = 1

    for i in range(len(points)):
        coord, type = points[i]

        if coord > prev_coord:

            if current_count > max_count:
                max_count = current_count
                best_L = prev_coord

        current_count += type

        prev_coord = coord

    print(f"{best_L} {n - best_L}")


t = int(sys.stdin.readline())

for _ in range(t):
    solve()
