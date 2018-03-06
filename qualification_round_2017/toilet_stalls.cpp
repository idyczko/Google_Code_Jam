#include <cstdio>
#include <iostream>
#include <map>

using namespace std;

void _main(long long N, long long K){
  map<long long, long long> Q;
  Q[N] = 1;
  while(K > 0) {

  }
  printf("%lld %lld", ((--Q.end())->first)/2, ((--Q.end())->first -1)/2;
}

int main() {
  int T, t;
  long long N, K;
  scanf("%d", T);
  t = 1;
  while(t++ <= T) {
    scanf("%lld %lld", &N, &K);
    printf("Case #%d: ", t);
    _main(N, K);
  }
}
