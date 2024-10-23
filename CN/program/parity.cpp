#include <stdio.h>
bool get_parity(int n)
{
	bool parity = 0;
	while(n)
	{
		parity = !parity;
		n = n & (n-1);
	}
	return parity;
}
int main()
{
	int n;
	
	printf("Enter a number to check it's parity: ");
	scanf("%d",&n);
	printf("Parity of number %d is %s", n, (get_parity(n) ? "odd" : "even" ));
	return 0;
}
