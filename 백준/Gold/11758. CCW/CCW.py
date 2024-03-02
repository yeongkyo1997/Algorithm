import sys
def input(): return sys.stdin.readline().rstrip()


p1 = list(map(int, input().split()))
p2 = list(map(int, input().split()))
p3 = list(map(int, input().split()))


def direction(p1, p2, p3):
    cross_product = (p2[0] - p1[0]) * (p3[1] - p2[1]) - \
        (p2[1] - p1[1]) * (p3[0] - p2[0])
    if cross_product > 0:
        return 1
    elif cross_product < 0:
        return -1
    else:
        return 0


print(direction(p1, p2, p3))