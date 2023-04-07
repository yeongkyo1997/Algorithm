import itertools
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    result = float('inf')

    house, chicken = [], []
    for i in range(n):
        row = list(map(int, input().split()))
        for j in range(n):
            if row[j] == 1:
                house.append((i, j))
            elif row[j] == 2:
                chicken.append((i, j))

    for combi in itertools.combinations(chicken, m):
        total_distance = 0

        for r1, c1 in house:
            distance = float('inf')

            for r2, c2 in combi:
                distance = min(distance, abs(r1 - r2) + abs(c1 - c2))
                total_distance += distance
                result = min(result, total_distance)
    print(result)


if __name__ == '__main__':
    main()
