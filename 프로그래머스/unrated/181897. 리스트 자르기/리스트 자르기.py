def solution(n, slicer, num_list):
    a, b, c = slicer
    return num_list[:b+1] if n == 1 else num_list[a:] if n == 2 else num_list[a:b+1] if n == 3 else num_list[a:b+1:c]
