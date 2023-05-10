import sys

def main():
    for line in sys.stdin:
        data = list(map(int, line.strip().split()))
        n = data[0]
        coords = [(data[i], data[i+1]) for i in range(1, 2 * n + 1, 2)]

        meeting_locations = []
        for i in range(n):
            x1, y1 = coords[i]
            x2, y2 = coords[(i+1) % n]
            meeting_locations.append(((x1 + x2) / 2, (y1 + y2) / 2))

        print(n, end=" ")
        for x, y in meeting_locations:
            print(f"{x:.6f} {y:.6f}", end=" ")
        print()

if __name__ == "__main__":
    main()