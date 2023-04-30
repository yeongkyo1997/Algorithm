import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    while True:
        s = input()
        if s == '.':
            break
        stack = []
        flag = True
        for i in s:
            if i == '(' or i == '[':
                stack.append(i)
            elif i == ')':
                if stack and stack[-1] == '(':
                    stack.pop()
                else:
                    flag = False
                    break
            elif i == ']':
                if stack and stack[-1] == '[':
                    stack.pop()
                else:
                    flag = False
                    break
        if flag and not stack:
            print('yes')
        else:
            print('no')


if __name__ == '__main__':
    main()