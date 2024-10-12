import math


def calc(x):
    return A * x + B * math.sin(x) - C


if __name__ == '__main__':
    A, B, C = map(int, input().split())
    x = 0
    while math.fabs(calc(x)) > 1e-9:
        x = x - (calc(x)) / (A + B * math.cos(x))

    print(f'{x:.11f}')