import sys


n = int(sys.stdin.readline())


for i in range(1, n + 1):

    leading_spaces = " " * (n - i)

    if i == 1:

        star_part = "*"
    else:

        inner_spaces = " " * (2 * i - 3)
        star_part = "*" + inner_spaces + "*"

    print(leading_spaces + star_part)
