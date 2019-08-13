	#include <iostream>
	#include <algorithm>
	#include <stack>

	#define INF 123456789

	using namespace std;

	int V, E, start;
	int edge[20001];
	int visited[20001];

	struct uvw {
		int u;
		int v;
		int w;
	} arr[20001];


	int main()
	{
		cin >> V >> E >> start;
		for (int i = 1; i <= V; i++)
			edge[i] = INF;
		edge[start] = 0;
		for (int i = 0; i < E; i++)
			cin >> arr[i].u >> arr[i].v >> arr[i].w;
		stack <int> st;
		st.push(start);
		while (!st.empty())
		{
			if (visited[st.top()])
			{
				st.pop();
				continue;
			}
			int minv = -1;
			int minw = INF;
			int temp = st.top();
			st.pop();
			visited[temp] = 1;
			for (int i = 0; i < E; i++)
			{
				if (arr[i].u == temp)
				{
					minv = minv == -1 ? (minw = arr[i].w, minv = arr[i].v) : (minw = min(minw, arr[i].w), minv = minw < arr[i].w ? minv : arr[i].v);
					//조원빈식 코딩을 지양합시다.
					st.push(arr[i].v);
					edge[arr[i].v] = min(edge[arr[i].v], edge[temp] + arr[i].w);
				}
			}
			st.push(minv);
		}

		for (int i = 1; i <= V; i++)
			(edge[i] != INF ? cout << edge[i] : cout << "INF") << endl;



	}
