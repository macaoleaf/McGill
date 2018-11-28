#include <stdio.h>

int main()
{
	for (int i = 1; i > 0; i++)
	{
		double buffer = 1 / (double)i;
		double result = 1 / buffer;
		if (i != result)
		{
			printf("%d\n", i);
			i = -1;
		}
	}
	return 0;
}
