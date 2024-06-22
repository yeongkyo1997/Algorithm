def expand_drawing(K):
    original_drawing = [
        "G...",
        ".I.T",
        "..S."
    ]
    
    N = len(original_drawing)  
    M = len(original_drawing[0])  
    
    expanded_drawing = []
    
    for i in range(N):
        for _ in range(K):
            expanded_row = ""
            for j in range(M):
                expanded_row += original_drawing[i][j] * K  
            expanded_drawing.append(expanded_row)
    
    return expanded_drawing

def print_expanded_drawing(expanded_drawing):
    for row in expanded_drawing:
        print(row)

K = int(input().strip())

expanded_drawing = expand_drawing(K)

print_expanded_drawing(expanded_drawing)