def trapped_water(h, w, blocks):
    left_max = [0] * w
    right_max = [0] * w
    
    left_max[0] = blocks[0]
    right_max[-1] = blocks[-1]
    
    for i in range(1, w):
        left_max[i] = max(left_max[i-1], blocks[i])

    for i in range(w-2, -1, -1):
        right_max[i] = max(right_max[i+1], blocks[i])

    trapped_water_amt = 0
    
    for i in range(1, w-1):
        min_height = min(left_max[i], right_max[i])
        trapped_water_amt += max(0, min_height - blocks[i])
    
    return trapped_water_amt

h, w = map(int, input().split())
blocks = list(map(int, input().split()))

result = trapped_water(h, w, blocks)
print(result)