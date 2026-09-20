#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef int (* Figure_area) (struct Figure*);
typedef void (* Figure_Print) (struct Figure*);
typedef void (* Figure_move) (struct Figure*,int,int);

typedef struct {
    void (* move) (struct Figure*);
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*,int,int);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

//metodos e construtor de figure

typedef struct {
    Figure super;
    int w, h;
} Rect;

void Rect_move (Rect* this,int dx,int dy) {
    Figure* sup = (Figure*) this;
    sup->x+=dx;
    sup->y+=dy;
}

void Rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

int Rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable Rect_vtable = {
    (Figure_Print) Rect_print;
    (Figure_Area)  Rect_area;
    (Figure_move)  Rect_move;
};
Rect* Rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

//vtable adicionado

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

int Arc_area (Arc* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

Figure_vtable Arc_vtable = {
    (Figure_Print) Arc_print;
    (Figure_Area)  Arc_area;
    (Figure_move)  Arc_move;
};

Arc* Arc_new (int x, int y, int w, int h,int ang1,int ang2) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &Arc_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->ang1 = ang1;
    this->ang2 = ang2;
}

//vtable adicionado
void main () {
    Figure* figs[4] = {
        (Figure*) Rect_new(10,10,100,100),
        (Figure*) Arc_new(40,10,140,300,0,340),
        (Figure*) Rect_new(10,10,100,100),
        (Figure*) Arc_new(210,110,305,130,0,240)
    };


    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
        figs[i]->vtable->move(figs[i],10,20);
        figs[i]->vtable->area(figs[i]);
    }

    //metodos virtuais utilizados a partir de vtable
    

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
