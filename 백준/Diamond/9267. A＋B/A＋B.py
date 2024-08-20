import sys

input = lambda: sys.stdin.readline().rstrip()


def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)


def cal(a, b):
    if a == 1:
        return 1, 0
    if b == 1:
        return 0, 1

    swapped = False
    if a < b:
        a, b = b, a
        swapped = True

    temp1, temp2 = divmod(a, b)
    x, y = cal(temp2, b)
    ans = (x, -temp1 * x + y)

    if swapped:
        ans = (ans[1], ans[0])
    return ans


def main():
    a, b, S = map(int, input().split())

    if S == 0:
        print("NO" if a > 0 and b > 0 else "YES")
        return

    if a == 0:
        if b == 0:
            print("NO")
        else:
            print("YES" if S % b == 0 else "NO")
        return

    if b == 0:
        print("YES" if S % a == 0 else "NO")
        return

    if a == S or b == S:
        print("YES")
        return

    g = gcd(abs(a), abs(b))
    if S % g != 0:
        print("NO")
        return

    a //= g
    b //= g
    S //= g

    x, y = cal(abs(a), abs(b))
    x *= S
    y *= S

    if a < 0:
        x = -x
    if b < 0:
        y = -y

    if x < y:
        x, y = y, x
        a, b = b, a

    num1 = (x - 1) // b
    y += num1 * a
    x -= b * num1

    while y > 0:
        if x > 0 and y > 0 and gcd(x, y) == 1:
            print("YES")
            return
        x += b
        y -= a

    print("NO")


if __name__ == "__main__":
    main()