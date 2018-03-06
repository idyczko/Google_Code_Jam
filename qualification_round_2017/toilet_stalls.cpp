#include <cstdio>
#include <iostream>
#include <map>

using namespace std;

void _main(long long N, long long K){
  map<long long, long long> Q;
  Q[N] = 1;
  while (K > 0) {
    long long n = (--Q.end())->first;
    long long k = (--Q.end())->second;
    if(k >= K)
      break;
    Q[n/2] += k;
    Q[(n-1)/2] += k;
    K -= k;
    Q.erase(--Q.end());
  }
  printf("%lld %lld\n", ((--Q.end())->first)/2, ((--Q.end())->first -1)/2);
}

int main() {
  int T, t;
  long long N, K;
  scanf("%d", &T);
  t = 0;
  while(++t <= T) {
    scanf("%lld %lld", &N, &K);
    printf("Case #%d: ", t);
    _main(N, K);
  }
}
