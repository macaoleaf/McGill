#include <stdio.h>

int main()
{
	float x = 100;
	for (int i = 2; i <= 70; i++)
	{
		x = 100 * x / (float)i;
		printf("x_%d = %e\n", i, x);
	}
	return 0;
}
