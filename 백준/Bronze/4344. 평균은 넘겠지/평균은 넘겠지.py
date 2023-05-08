t = int(input())

for _ in range(t):
    arr = list(map(int, input().split()))[1:]
    avg = sum(arr) / len(arr)
    cnt = len([score for score in arr if score > avg])
    rate = cnt / len(arr) * 100
    print(f'{rate:.3f}%')