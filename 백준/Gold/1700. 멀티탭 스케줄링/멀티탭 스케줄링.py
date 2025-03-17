import sys

def main():
    n, k = map(int, sys.stdin.readline().split())
    sequence = list(map(int, sys.stdin.readline().split()))
    current = set()
    count = 0

    for i in range(k):
        app = sequence[i]
        if app in current:
            continue
        if len(current) < n:
            current.add(app)
        else:
            farthest = -1
            remove_candidate = None
            found = False
            
            for plug in current:
                next_idx = -1
                for j in range(i+1, k):
                    if sequence[j] == plug:
                        next_idx = j
                        break
                if next_idx == -1:
                    remove_candidate = plug
                    found = True
                    break
                if next_idx > farthest:
                    farthest = next_idx
                    remove_candidate = plug
            
            current.remove(remove_candidate)
            current.add(app)
            count += 1
    
    print(count)

if __name__ == "__main__":
    main()