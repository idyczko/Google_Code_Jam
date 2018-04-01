#include <cstdio>
#include <queue>

using namespace std;

class CompareCount
{
public:
    bool operator()(pair<char,int> n1,pair<char,int> n2) {
        return n1.second<n2.second;
    }
};

int main() {
  int T, N, t = 0;
  int Pi;
  scanf("%d", &T);
  while (++t <= T) {
    char party = 'A';
    priority_queue<pair<char, int>, vector<pair<char, int> >, CompareCount> Q;
    scanf("%d", &N);
    int sum = 0;
    while (--N >= 0) {
      scanf("%d", &Pi);
      sum += Pi;
      Q.push(make_pair(party++, Pi));
    }
    printf("Case #%d: ", t);
    while (!Q.empty()) {
      //if(--Q.end->second )
      pair<char, int> p = Q.top();
      Q.pop();
      sum--;
      printf("%c", p.first);
      if(p.second > 1)
        Q.push(make_pair(p.first, p.second - 1));
      if(!(sum == 2 && Q.size() == 2)) {
        pair<char, int> p = Q.top();
        Q.pop();
        sum--;
        printf("%c", p.first);
        if(p.second > 1)
          Q.push(make_pair(p.first, p.second - 1));
      }

      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
