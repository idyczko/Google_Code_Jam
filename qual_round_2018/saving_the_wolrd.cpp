#include <cstdio>
#include <iostream>
#include <cstdlib>
#include <cmath>

void _main(long long D, char *P) {
  int num[50];
  for (int i = 0; i < 50; i++)
    num[i] = 0;
  int index = 0, shooting_count = 0;
  long long damage = 0;
  while (*P != '\0') {
    if (*P++ == 'S') {
      shooting_count++;
      num[index]++;
      damage += pow(2, index);
    } else {
      index++;
    }
  }
  if (shooting_count > D) {
    printf("IMPOSSIBLE\n");
    return;
  }
  int moves = 0;
  while (D < damage) {
    if(num[index] == 0){
      index--;
      continue;
    }
    num[index]--;
    num[index - 1]++;
    damage -= pow(2, index - 1);
    moves++;
  }
  printf("%d\n", moves);
  return;
}

int main() {
  int T, t = 0;
  long long D;
  char *P;
  scanf("%d", &T);
  while (++t <= T) {
    scanf("%lld %s", &D, P);
    printf("Case #%d: ", t);
    _main(D, P);
  }
  return 0;
}
