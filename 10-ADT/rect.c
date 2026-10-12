#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

void Rect_move (Rect* this,int dx,int dy) {
    Figure* sup = (Figure*) this;
    sup->x+=dx;
    sup->y+=dy;
}

void Rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Linha de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* Rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Rect_print;
    sup->move = (Figure_move) Rect_move;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}
