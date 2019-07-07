#include <iostream>

using namespace std;

int sum[1000][1000];
int main() {

	int C;
	cin >> C;
	for (int c = 0; c < C; c++) {

		int N, L;
		int price[1000];

		cin >> N >> L;
		for (int i = 0; i < N; i++)
			cin >> sum[i][i];


		for (int i = 1; i < N; i++)
			for (int j = 0; j < i; j++)
				sum[j][i] = sum[j][i - 1] + sum[i][i];

		double least = (double)sum[0][L - 1] / L;
		for (int i = 0; i <= N - L; i++)
			for (int j = L - 1; i + j < N; j++)
				if (least > (double)sum[i][i + j] / (j + 1))
					least = (double)sum[i][i + j] / (j + 1);
		cout << fixed;
		cout.precision(8);
		cout << least << endl;
	}
}
