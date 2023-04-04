import sys

input = sys.stdin.readline

expr = input()
expr = expr.strip()
if expr.find("()") != -1:
    print("ROCK")
    quit()

rep = '&'
chk = expr.replace('/', rep).replace('-', rep).replace('+', rep).replace('*', rep)

try:
    eval(chk)
except:
    print("ROCK")
    quit()

try:
    print(eval(expr.replace('/', "//")))
except:
    print("ROCK")
