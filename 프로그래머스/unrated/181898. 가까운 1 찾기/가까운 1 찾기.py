def solution(arr, idx):
    for i, ele in enumerate(arr[idx:], start=idx):
        if ele == 1:
            return i
        
    return -1