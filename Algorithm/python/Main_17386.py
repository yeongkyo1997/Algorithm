import sys

input = lambda: sys.stdin.readline().rstrip()

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

mx1, mx2, my1, my2 = min(x1, x2), max(x1, x2), min(y1, y2), max(y1, y2)
mx3, mx4, my3, my4 = min(x3, x4), max(x3, x4), min(y3, y4), max(y3, y4)

A, B, C, D = [x1, y1], [x2, y2], [x3, y3], [x4, y4]


def ccw(p1, p2, p3):
    return (p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1]) - (p1[1] * p2[0] + p2[1] * p3[0] + p3[1] * p1[0])


AB = ccw(A, B, C) * ccw(A, B, D)
CD = ccw(C, D, A) * ccw(C, D, B)
if AB == 0 and CD == 0:
    if mx1 <= mx4 and mx2 <= mx3 and my1 <= my4 and my2 <= my3:
        print(1)
    else:
        print(0)
elif AB <= 0 and CD <= 0:
    print(1)
else:
    print(0)
