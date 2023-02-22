#include <stdio.h>

int Intensity_function(int R,int G,int B) {
    return 2126 * R + 7152 * G + 722 * B;
}

int main(){
    int n, m;
    int r,g,b;

    scanf("%d" "%d", &n, &m);

    for (int i = 1; i <= n; i++) {
     
		for (int j = 1; j <= m; j++) {
            scanf("%d" "%d" "%d", &r, &g, &b);

            int tmp = Intensity_function(r, g, b);

            if (0 <= tmp && tmp < 510000)
                printf("%c", 35);

            else if (510000 <= tmp && tmp < 1020000)
                printf("%c", 111);

            else if (1020000 <= tmp && tmp < 1530000)
                printf("%c", 43);

            else if (1530000 <= tmp && tmp < 2040000)
                printf("%c", 45);

            else
                printf("%c", 46);
        }
        printf("\n");
    }
}