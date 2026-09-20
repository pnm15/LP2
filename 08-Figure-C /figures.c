#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef void (* Figure_move) (struct Figure*,int,int);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
    void (* move) (struct Figure*,int,int);
} Figure;

//metodos e construtor de figure

typedef struct {
    Figure super;
    int w, h;
} Line;

void Line_move (Line* this,int dx,int dy) {
    Figure* sup = (Figure*) this;
    sup->x+=dx;
    sup->y+=dy;
}

void Line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Line* Line_new (int x, int y, int w, int h) {
    Line*   this  = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->move = (Figure_move) Line_move;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

//metodos, metodos virtuais e construtor de Line

typedef struct {
    Figure super;
    int w, h;
    int ang1, ang2;
} Arc;

void Arc_move (Arc* this,int dx,int dy) {
    Figure* sup = (Figure*) this;
    sup->x+=dx;
    sup->y+=dy;
}

void Arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Arc* Arc_new (int x, int y, int w, int h,int ang1,int ang2) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Arc_print;
    sup->move = (Figure_move) Arc_move;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->ang1 = ang1;
    this->ang2 = ang2;
}

//metodos, metodos virtuais e construtor de Arc
void main () {
    Figure* figs[4] = {
        (Figure*) Line_new(10,10,100,100),
        (Figure*) Arc_new(40,10,140,300,0,340),
        (Figure*) Line_new(10,10,100,100),
        (Figure*) Arc_new(210,110,305,130,0,240)
    };


    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
         figs[i]->move(figs[i],10,20);
    }

    //cria as figuras dentro de um vetor e utilizar metodos virtuais
    

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
