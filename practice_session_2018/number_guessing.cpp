#include <stdio.h>
#include <string.h>

const char *correct = "CORRECT";
const char *too_small = "TOO_SMALL";
const char *too_big = "TOO_BIG";
const char *wrong_answer = "WRONG_ANSWER";

int main() {
    int T, N, t = 0;
    long long A, B;
    char *line;
    scanf("%d", &T);
    while (++t <= T) {
        scanf("%lld %lld", &A, &B);
        scanf("%d", &N);
        while(1) {
          printf("%lld\n", (A+B)/2 + 1);
          fflush(stdout);
          scanf("%s", line);
          if (strcmp(line, correct) == 0)
            break;
          if (strcmp(line, wrong_answer) == 0)
            return -1;
          if (strcmp(line, too_small) == 0)
            A = (A+B)/2 + 1;
          if (strcmp(line, too_big) == 0)
            B = (A+B)/2;
        }
    }
    return 0;
}
