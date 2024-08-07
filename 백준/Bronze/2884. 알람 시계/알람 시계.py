H, M = map(int, input().split())
M -= 45
if M < 0:
    H -= 1

print(H % 24, M % 60)