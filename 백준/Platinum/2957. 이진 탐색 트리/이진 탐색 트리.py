import bisect
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    arr_size = int(input())
    tree = [(0, -1), (300001, -1)]
    counter = 0

    for _ in range(arr_size):
        x = int(input())

        low_idx = bisect.bisect_left(tree, (x, -1)) - 1
        up_idx = bisect.bisect_right(tree, (x, -1))

        low_it, up_it = tree[low_idx], tree[up_idx]

        dep = max(low_it[1], up_it[1]) + 1

        bisect.insort(tree, (x, dep))

        counter += dep
        print(counter)


if __name__ == "__main__":
    main()