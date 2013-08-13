/*
 * Compile with:
 *   gcc -o generate gen_test_sets.c
 * and then run './generate' from this directory to create test files
 */
#include <stdio.h>
#include <stdint.h>

void generate_2op( char* path, uint8_t (*f)(uint8_t, uint8_t), 
        int op1_upper_bound, int op2_upper_bound ) {

    uint8_t op1, op2;
    int i, j;
    FILE* file = fopen(path, "w");

    for (i = 0; i < op1_upper_bound; i++) {
        for (j = 0; j < op2_upper_bound; j++) {
            op1 = (uint8_t) i;
            op2 = (uint8_t) j;
            fprintf(file, "%02x", (*f)(op1, op2));
            if (j != op2_upper_bound - 1) {
                fprintf(file, " ");
            }
        }
        fprintf(file, "\n");
    }
    fclose(file);
}

uint8_t and(uint8_t op1, uint8_t op2) {
    return op1 & op2;
}

uint8_t not(uint8_t op1, uint8_t op2) {
    return ~op1;
}

uint8_t or(uint8_t op1, uint8_t op2) {
    return op1 | op2;
}

uint8_t xor(uint8_t op1, uint8_t op2) {
    return op1 ^ op2;
}

uint8_t rrotate(uint8_t op1, uint8_t op2) {
    return (op1 >> op2) | (op1 << (8-op2));
}

uint8_t lrotate(uint8_t op1, uint8_t op2) {
    return (op1 << op2) | (op1 >> (8-op2));
}

uint8_t rshift(uint8_t op1, uint8_t op2) {
    return op1 >> op2;
}

uint8_t lshift(uint8_t op1, uint8_t op2) {
    return op1 << op2;
}

int main() {
    generate_2op("and_testset.txt", and, 256, 256);
    generate_2op("or_testset.txt", or, 256, 256);
    generate_2op("xor_testset.txt", xor, 256, 256);
    generate_2op("not_testset.txt", not, 256, 1);
    generate_2op("rrotate_testset.txt", rrotate, 256, 8);
    generate_2op("lrotate_testset.txt", lrotate, 256, 8);
    generate_2op("rshift_testset.txt", rshift, 256, 8);
    generate_2op("lshift_testset.txt", lshift, 256, 8);
}

