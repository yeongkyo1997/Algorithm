a, b = map(int, input().split())
c = int(input())

time = a * 60 + b + c
hour = time // 60 % 24
minute = time % 60

print(hour, minute)