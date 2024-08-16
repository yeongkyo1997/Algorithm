def solve(s):
    stack = []
    ret = 0

    for i in range(len(s)):
        if s[i] == '(':
            stack.append('(')
        else:
            stack.pop()
            if s[i - 1] == '(':
                ret += len(stack)
            else:
                ret += 1

    return ret


s = input().strip()

result = solve(s)
print(result)