A, B = map(int, input().split())
C = int(input())

print((A * 60 + B + C) // 60 % 24, (A * 60 + B + C) % 60)