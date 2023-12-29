def solution(sizes):
    max_width, max_height = map(max, zip(*[(min(size), max(size)) for size in sizes]))
    return max_width * max_height
