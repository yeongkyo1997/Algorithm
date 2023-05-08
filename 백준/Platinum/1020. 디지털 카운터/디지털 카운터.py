import sys

def line_count(c):
    lineCnt = [6, 2, 5, 5, 4, 5, 6, 3, 7, 5]
    return lineCnt[int(c)]

def solve(pos, left, bigger):
    if left < 0:
        return 10
    if pos == len(s):
        return 0 if bigger and not left else 10

    if (pos, left, bigger) in dp:
        return dp[(pos, left, bigger)]

    ret = 10
    for i in range(0 if bigger else int(s[pos]), 10):
        next_val = solve(pos + 1, left - line_count(i), bigger or (i > int(s[pos])))
        if next_val != 10:
            ret = i
            break

    dp[(pos, left, bigger)] = ret
    return ret

def go(pos, left, bigger):
    if pos == len(s):
        return 0

    ret = dp[(pos, left, bigger)]
    go_ret[0] = go_ret[0] * 10 + ret
    go(pos + 1, left - line_count(ret), bigger or (ret > int(s[pos])))

def ten_pow(a):
    return 10 * ten_pow(a - 1) if a else 1

input_str = input().strip()
sum_lines = sum(line_count(c) for c in input_str)

dp = {}
s = '0' * len(input_str)
solve(0, sum_lines, False)
go_ret = [0]
go(0, sum_lines, False)
ans = go_ret[0] - int(input_str) + ten_pow(len(s))

dp = {}
s = input_str
if solve(0, sum_lines, False) != 10:
    go_ret = [0]
    go(0, sum_lines, False)
    ans = go_ret[0] - int(input_str)

print(ans)