#include <cstdio>
#include <iostream>

using namespace std;

void flip(char *pncs, int flpr) {
  for (; flpr-- > 0; pncs++)
    *pncs = *pncs == '+' ? '-' : '+';
}

void _main(char *pncs, const int flpr) {
  int flips = 0;
  char *ptr = pncs;
  for (; *(ptr + (flpr - 1)) != '\0'; ptr++)
    if (*ptr == '-')
      flip(ptr, flpr), flips++;
  while (*ptr != '\0')
    if (*ptr++ == '-') {
      printf("IMPOSSIBLE\n");
      return;
    }
  printf("%d\n", flips);
}

int main() {
  int T, t = 0;
  char *pncs;
  int flpr;
  scanf("%d", &T);
  while(++t <= T) {
    printf("Case #%d: ", t);
    scanf("%s %d", pncs, &flpr);
    _main(pncs, flpr);
  }
  return 0;
}
