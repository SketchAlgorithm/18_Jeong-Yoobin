#include <iostream>
#include <queue>


using namespace std;

int M, N;
int tom[1000][1000];
int visited[1000][1000];
queue<pair<int, int>*> st;


void bfs()
{
	int depth = 1;
	while (st.size() > 0)
	{

		int size = st.size();
		for (int i = 0; i < size; i++) {

			pair<int, int>* temp = st.front();
			st.pop();
			if (temp->first == -1 || temp->first == M || temp->second == -1 || temp->second == N || visited[temp->first][temp->second] == 1) {
				delete temp;
				continue;
			}

			visited[temp->first][temp->second] = 1;

			if (tom[temp->first][temp->second] == 0)
				tom[temp->first][temp->second] = depth;

			if (tom[temp->first][temp->second] > 0)
			{
				st.push(new pair<int, int>(temp->first - 1, temp->second));
				st.push(new pair<int, int>(temp->first + 1, temp->second));
				st.push(new pair<int, int>(temp->first, temp->second - 1));
				st.push(new pair<int, int>(temp->first, temp->second + 1));
			}

			delete temp;
		}
		depth++;
	}
}

int main()
{
	cin >> N >> M;
	for (int i = 0; i < M; i++)
		for (int j = 0; j < N; j++)
		{
			int temp;
			cin >> temp;
			if (temp == 1)
				st.push(new pair<int, int>(i, j));
			tom[i][j] = temp;
			visited[i][j] = 0;
		}

	bfs();


	int max = 0;
	for (int i = 0; i < M; i++)
		for (int j = 0; j < N; j++)
			if (tom[i][j] == 0)
			{
				cout << -1;
				return 0;
			}
			else if (tom[i][j] > max)
				max = tom[i][j];
	cout << max - 1;

}
