import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

while True:
    string = input()
    
    if string == 'END':
        break
    
    print(string[::-1])