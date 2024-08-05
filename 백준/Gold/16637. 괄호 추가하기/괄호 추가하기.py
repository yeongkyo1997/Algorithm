import copy
import math
import re

N = int(input())
s = input()
symbol = re.split('[0-9]', s)[1:]
num = re.split('[\-*+]', s)
s_list = list(s)
result = -math.inf


def check_bracket(calc):
    stack = []
    for c in calc:
        if c == '(':
            if stack:
                return False
            stack.append('(')
        elif c == ')':
            if not stack:
                return False
            stack.pop()
    return True


def postfix(calc):
    ret = ''
    stack = []
    for c in calc:
        if c in '+-*':
            while stack and stack[-1] != '(':
                ret += stack.pop()
            stack.append(c)
        elif c == '(':
            stack.append(c)
        elif c == ')':
            while stack and stack[-1] != '(':
                ret += stack.pop()
            stack.pop()
        else:
            ret += c

    while stack:
        ret += stack.pop()
    return ret


def calc_postfix(calc):
    stack = []
    for c in calc:
        if c.isdigit():
            stack.append(int(c))
        else:
            b = stack.pop()
            a = stack.pop()
            if c == '+':
                stack.append(a + b)
            elif c == '-':
                stack.append(a - b)
            elif c == '*':
                stack.append(a * b)
    return int(stack.pop())


for i in range(1, 1 << len(num)):
    arr = []
    for j in range(len(num) - 1):
        if i & (1 << j):
            arr.append(j)
    tmp = copy.deepcopy(num)
    for i in arr:
        tmp[i] = f'({num[i]}'
        tmp[i + 1] = f'{num[i + 1]})'

    zip_list = list(zip(tmp, symbol))
    calc = ''.join(''.join(ele) for ele in zip_list).strip()

    if check_bracket(calc):
        result = max(result, calc_postfix(postfix(calc)))

print(result)