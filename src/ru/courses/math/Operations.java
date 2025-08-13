package ru.courses.math;

enum Operations {
    PLUS {
        @Override
        int operation(int x, int y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        int operation(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        int operation(int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        int operation(int x, int y) {
            return x / y;
        }
    };
   abstract int operation(int x, int y);
}
