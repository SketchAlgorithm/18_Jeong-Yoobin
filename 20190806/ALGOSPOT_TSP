#include <iostream>
#include <set>

using namespace std;

double matrix[1000][1000];
int degree[1000];
int city;

bool isPossible()
{
	int sum = 0;
	for (int i = 0; i < city; i++)
		if (degree[i] > 2)
			return false;
	for (int i = 0; i < city; i++)
		if (degree[i] == 1)
			return true;
	return false;

}

double func()
{
	int min_vertex1 = 0, min_vertex2 = 0;
	for(int i = 0; i<city; i++)
		for (int j = 0; j < i+1; j++)
		{
			if (i == j)
				continue;
			if (matrix[i][j] >= 0 && matrix[i][j] < matrix[min_vertex1][min_vertex2])
			{
				min_vertex1 = i;
				min_vertex2 = j;
			}
		}
	double temp = matrix[min_vertex1][min_vertex2];
	degree[min_vertex1]++;
	degree[min_vertex2]++;
	matrix[min_vertex1][min_vertex2] = -1;

	if (!isPossible())
	{
		matrix[min_vertex1][min_vertex2] = -2;
		degree[min_vertex1]--;
		degree[min_vertex2]--;
		return 0;
	}

	return temp;
}




void init()
{
	cin >> city;
	for (int i = 0; i < city; i++)
	{
		for (int j = 0; j < city; j++)
			cin >> matrix[i][j];	
		degree[i] = 0;
	}
	matrix[0][0] = 12345678;
}

int main()
{

	int testcase;
	cin >> testcase;
	while (testcase--)
	{
		double result = 0;
		init();
		for (int i = 0; i < (city*(city + 1)) / 2; i++)
			result += func();

		printf("%.10f", result);
	}
}
