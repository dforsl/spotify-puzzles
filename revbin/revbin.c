/*
	Simple program utilising bitwise operations for converting a digit A to the digit B corresponding to A's binary reversed representation.
	
	It reads the digit from standard input, only accepting digits in the interval 1 <= digit <= 1000000000.

	Author:
	Daniel Forslund
	dforsl@kth.se
*/

#include <stdio.h>

int main(void) {
	int number, i = 0;

	/* read the input from stdin */
	scanf("%d", &number);

	/* check the parameters */
	if(number < 1 || number > 1000000000) {
		printf("Parameter not in range.\n");
		return 1;
	}

	/* loop until ẗhere are no bits left */
	while(number > 0) {
		/* simply bitshift to the left */
		i <<= 1;

		/* bitwise AND with 1 to get the least significant bit, if 1, increase i */
		if(number & 1)
			i++;

		/* divide the number by 2 (and floor duh) */
		number >>= 1;
	}

	/* print it */
	printf("%d\n", i);

	return 0;
}