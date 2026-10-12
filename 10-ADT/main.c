#include <stdlib.h>
#include "rect.h"

void main (void) {
    Rect* r1 = Rect_new(50,50,50,50);
    Rect_print(r1);

    Rect* r2 = Rect_new(100,100,100,100);
    Rect_move(r2, 10,100);
    Rect_print(r2);

    free(r1);
    free(r2);
}
