import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        arr = input()
        if arr == '.':
            break

        stack = []
        for i in arr:
            if i == '(' or i == '[':
                stack.append(i)
            elif i == ')':
                if stack and stack[-1] == '(':
                    stack.pop()
                else:
                    stack.append(i)
                    break
            elif i == ']':
                if stack and stack[-1] == '[':
                    stack.pop()
                else:
                    stack.append(i)
                    break

        if stack:
            print('no')
        else:
            print('yes')


if __name__ == '__main__':
    main()