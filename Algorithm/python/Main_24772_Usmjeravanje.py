import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    a, b = map(int, input().split())
    m = int(input())
    arr = [[], []]
    idx = {}
    result = [0] * (m + 1)

    for i in range(m):
        x, y = map(int, input().split())
        arr[0].append((x, y))
        arr[1].append((y, x))
        idx[(x, y)] = i

    arr[0].sort()
    arr[1].sort()
    x, y = 0, 0
    output = a + b

    while x < len(arr[0]) and y < len(arr[1]):
        ax, ay = arr[0][x][0], arr[1][y][0]
        t1 = arr[1][y][1]
        t2 = arr[0][x][1]
        result[idx[arr[0][x]]] = 1
        flag = True

        while flag:
            flag = False

            if x < len(arr[0]) and arr[0][x][0] <= t1:
                if t2 < arr[0][x][1]:
                    result[idx[arr[0][x]]] = 1

                t2 = max(t2, arr[0][x][1])
                x += 1
                flag = True

            if y < len(arr[1]) and arr[1][y][0] <= t2:
                t1 = max(t1, arr[1][y][1])
                y += 1
                flag = True

        if t1 == ax and t2 == ay:
            continue

        if t1 == ax:
            result[idx[(ax, ay)]] = 0

        if t2 == ay:
            result[idx[(ax, ay)]] = 1

        output -= (t1 - ax + 1) + (t2 - ay + 1) - 1

    print(output)
    print(*result[:m])


if __name__ == '__main__':
    main()
