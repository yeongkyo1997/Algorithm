import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline


def recursion(n):
    if n == 1:
        return ["*"]
    stars = recursion(n // 3)
    arr = []

    arr.extend(i * 3 for i in stars)
    arr.extend(f"{i}{' ' * (n // 3)}{i}" for i in stars)
    arr.extend(i * 3 for i in stars)
    return arr


N = int(input())
print("\n".join(recursion(N)))
