#include <stdio.h>

int main()
{
	double x = 100;
	for (int i = 2; i <= 1000; i++)
	{
		x = 100 * x / (double)i;
		printf("x_%d = %e\n", i, x);
	}
	return 0;
}
