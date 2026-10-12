#ifndef RECT_H
#define RECT_H

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

typedef struct {
    Figure super;
    int w, h;
} Rect;

void Rect_move (Rect* this,int dx,int dy);
void Rect_print (Rect* this);
Rect* Rect_new (int x, int y, int w, int h);

#endif
