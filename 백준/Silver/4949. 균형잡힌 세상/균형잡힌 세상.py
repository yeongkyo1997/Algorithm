while True:
    s = input()
    if s == '.':
        break

    stack = []

    for a in s:
        if a in '([':
            stack.append(a)
        elif a == ')':
            if not stack or stack.pop() != '(':
                print('no')
                break
        elif a == ']':
            if not stack or stack.pop() != '[':
                print('no')
                break
    else:
        if stack:
            print('no')
        else:
            print('yes')