import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    str = input()
    stack = []
    
    for i in list(str):
        if i.isalpha():
            print(i, end='')
        else:
            if i == '(':
                stack.append(i)
            elif i == ')':
                stack.pop()
                while stack[-1] != ')':
                    print(stack.pop(), end='')
                stack.pop()
            elif i == '+' or i == '-':
                while stack[-1] == '*' or stack[-1] == '/':
                    stack.append(i)
            elif i == '*' or i == '/':
                print(i, end='')

if __name__ == '__main__':
    main()
