t = int(input())

for _ in range(t):
    j, n = map(int, input().split())
    boxes = []
    for _ in range(n):
        r, c = map(int, input().split())
        boxes.append(r*c)
    
    boxes.sort(reverse=True)
    
    count = 0
    for box in boxes:
        if j <= 0:
            break
        if j <= box:  
            j = 0
            count += 1
        else:
            j -= box
            count += 1
    
    print(count)