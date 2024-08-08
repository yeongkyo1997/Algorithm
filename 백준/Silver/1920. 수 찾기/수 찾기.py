N = int(input())
s = set(map(int, input().split()))

input()
for i in map(int, input().split()):
    print(int(i in s))