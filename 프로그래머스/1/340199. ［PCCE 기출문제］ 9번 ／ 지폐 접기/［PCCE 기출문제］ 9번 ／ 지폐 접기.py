def solution(wallet, bill):
    folds = 0
    w, h = bill[0], bill[1]
    wallet_w, wallet_h = wallet[0], wallet[1]
    
    while True:
        if (w <= wallet_w and h <= wallet_h) or (h <= wallet_w and w <= wallet_h):
            return folds
        
        if w >= h:
            w = w // 2
        else:
            h = h // 2
        
        folds += 1