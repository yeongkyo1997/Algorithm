def solution(picture, k):
    new_picture = []
    for row in picture:
        new_row = ''
        for pixel in row:
            new_row += pixel * k
        new_picture += [new_row] * k
    return new_picture
