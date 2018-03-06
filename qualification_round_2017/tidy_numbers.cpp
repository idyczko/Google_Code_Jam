#include <cstdio>
#include <iostream>

using namespace std;

void validate_last_two(char *last) {
  if(*last < *(last - 1)) {
    *(last - 1) = *(last - 1) - 1;
    while(*last != '\0')
      *last++ = '9';
  }
}

void _main(char *nmb) {
  char *last = nmb;
  while (*last++ != '\0');
  last -= 2;
  while (last != nmb)
    validate_last_two(last--);
  while (*nmb++ == '0');
  printf("%s\n", --nmb);
}

int main() {
  int T, t = 0;
  char *nmb;
  scanf("%d", &T);
  while (++t <= T) {
    scanf("%s", nmb);
    printf("Case #%d: ", t);
    _main(nmb);
  }
}
