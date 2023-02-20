#include <stdio.h>
#include <string.h>
 
int main() {
    int T = 0, q = 0;
    int at[9][2] = { {7, 1},
                     {2, 8},
                     {3, 8},
                     {3, 4},
                     {7, 5},
                     {6, 5},
                     {3, 0},
                     {8, 0},
                     {8, 8}
                    };
    char str[205] = "";
    
    scanf("%d", &T);
    
    while (T--) {
        scanf("%s", str);
        
        q = 0;
        
        for (int i = 0 ; i < strlen(str) ; i ++) q = at[q][str[i] - '0'];
        
        if (q == 0 || q == 4 || q == 5)
            printf("YES\n");
        else
            printf("NO\n");
    }
    
    return 0;
}