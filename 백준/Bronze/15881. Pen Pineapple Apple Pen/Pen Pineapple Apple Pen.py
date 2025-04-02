import sys

n = int(sys.stdin.readline())

items = sys.stdin.readline().strip()


count = 0

i = 0


while i <= n - 4:

    if items[i : i + 4] == "pPAp":

        count += 1

        i += 4
    else:

        i += 1


print(count)
