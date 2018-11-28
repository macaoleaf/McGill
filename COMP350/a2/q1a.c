#include <stdio.h>

int main()
{
	for (int i = 1; i > 0; i++)
	{
		float buffer = 1 / (float)i;
		float result = 1 / buffer;
		if (i != result)
		{
			printf("%d\n", i);
			i = -1;
		}
	}
	return 0;
}
