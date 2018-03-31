#include <cstdio>
#include <map>

#define MAX(a, b) a<b?b:a

using namespace std;

int main() {
  int T, t = 0;
  int N, Si;
  long long D, Ki;
  scanf("%d", &T);
  while(++t <= T) {
    map<long long, int> Q;
    scanf("%lld %d", &D, &N);
    while(--N >= 0) {
      scanf("%lld %d", &Ki, &Si);
      Q[Ki] = Si;
    }
    printf("Case #%d: ", t);
    long tin  = D - (--Q.end())-> first;
    int tid = (--Q.end())-> second;
    Q.erase(--Q.end());
    int i = 0;
    while (!Q.empty()) {
      if((((double) tin)/tid) < (((double) (D - (--Q.end())-> first)) / (--Q.end())-> second)) {
        tin = D - (--Q.end())-> first;
        tid = (--Q.end())-> second;
      }
      Q.erase(--Q.end());
    }
    printf("%.6f\n", ((double) D*tid)/tin);
  }
}
