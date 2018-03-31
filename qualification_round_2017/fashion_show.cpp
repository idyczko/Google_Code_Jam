#include <cstdio>
#include <iostream>
#include <cstdlib>

using namespace std;

struct move {
  int x;
  int y;
};

struct element {
  struct move *next;
  struct move *prev;
  struct move mov;
}

struct

void initialize(char **, int);
void destroy(char **, int);
void *calloc(size_t, size_t);
void print_tab(char **, int);
void free(void *);

void do_the_rooks(char **tab, int N) {
  char **rookies = (char **) calloc(sizeof(char *), N);
  for (int n = 0; n < N; n++)
    rookies[n] = (char *) calloc(sizeof(char), N);
  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      rookies[i][j] = tab[i][j] == '.' || tab[i][j] == '+' ? tab[i][j] : tab[i][j] == 'o' ? '+' : '.';

  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      if (rookies[i][j] == '+') {
        for (int i = 0; i < N; i++)
          for (int j = 0; j < N; j++)
      }
  print_tab(tab, N);
  printf("\n");
  print_tab(rookies, N);
}

int main() {
  int T, N, M;
  scanf("%d", &T);
  for (int t = 1; t <= T; t++) {
    scanf("%d %d", &N, &M);
    char **TAB = (char **) calloc(sizeof(char *), N);
    for (int n = 0; n < N; n++)
      TAB[n] = (char *) calloc(sizeof(char), N);
    initialize(TAB, N);
    for(int m = 0; m < M; m++) {
      char model;
      int i, j;
      scanf(" %c %d %d", &model, &i, &j);
      //printf("Howdie! %c %d %d\n", model, i, j);
      TAB[i-1][j-1] = model;
    }

    printf("Case #%d: \n", t);
    do_the_rooks(TAB, N);
    destroy(TAB, N);
    free(TAB);
  }
}

void destroy(char **TAB, int N) {
  for (int i = 0; i < N; i++)
    free(TAB[i]);
}

void initialize(char **tab, int N) {
  for (int i = 0; i < N; i++)
    for (int j = 0; j < N; j++)
      tab[i][j] = '.';
}

void print_tab(char **tab , int N) {
  for (int i = 0; i < N; i++){
    for (int j = 0; j < N; j++)
      printf("%c ", tab[i][j]);
    printf("\n");
  }
}
