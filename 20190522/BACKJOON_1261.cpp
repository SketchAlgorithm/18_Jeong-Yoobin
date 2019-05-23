#include <iostream>
#include <string>

using namespace std;

int cache[100][100] = { -1, };
int M, N;
int visited[100][100] = { 0, };
int map[100][100] = { 0, };

int min(int x, int y) {
	return x < y ? x : y;
}

void func(int x, int y, int prev) {
	visited[x][y] = 1;
	
	if (cache[x][y] != -1 && cache[x][y] <= prev + map[x][y])
	{
		visited[x][y] = 0;
		return;
	}

	cache[x][y] = prev + map[x][y];

	if (x > 0 && visited[x - 1][y] == 0)
		func(x - 1, y, cache[x][y]);
	if (y > 0 && visited[x][y - 1] == 0)
		func(x, y - 1, cache[x][y]);
	if (x < N - 1 && visited[x + 1][y] == 0)
		func(x + 1, y, cache[x][y]);
	if (y < M - 1 && visited[x][y + 1] == 0)
		func(x, y + 1, cache[x][y]);


	visited[x][y] = 0;
}

int main() {

	cin >> M;
	cin >> N;


	for (int i = 0; i < N; i++)
	{
		string tempstr;
		cin >> tempstr;
		for (int j = 0; j < M; j++) {
			map[i][j] = tempstr.at(j) - '0';
			cache[i][j] = -1;
		}
	}
	func(0, 0, 0);
	cout << cache[N - 1][M - 1];


}
