import sys, collections

sys.setrecursionlimit(100000)


input = lambda: sys.stdin.readline().rstrip()

T = int(input())
result = []

for _ in range(T):
    data = list(input())
    cnt = 0
    for d in data:
        if cnt == 0:
            if d == "(":
                cnt += 1
            else:
                result.append("NO")
                break
        else:
            if d == "(":
                cnt += 1
            else:
                if cnt == 0:
                    result.append("NO")
                    break
                else:
                    cnt -= 1
    else:
        if cnt == 0:
            result.append("YES")
        else:
            result.append("NO")

print("\n".join(result))
