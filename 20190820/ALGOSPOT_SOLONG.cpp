#include <iostream>
#include <string>
#include <algorithm>

#define ABC 26

using namespace std;

//아니 왜 잘 짠거같은데 런타임 뜨냐고 ㅡㅡ

struct trie
{
	char ch;
	int freq = -1; string word = "";	// leaf 노드들만 사용하는 변수
	trie* next[ABC] = { nullptr, };
};

trie* dfs(trie* temp, trie*& maxleaf)
{
	trie* tempmaxleaf = temp;
	if (temp->freq != -1)
		return temp;
	for (int i = 0; i < ABC; i++)
		if (temp->next[i] != nullptr && (tempmaxleaf = dfs(temp->next[i], maxleaf))->freq > maxleaf->freq)
			maxleaf = tempmaxleaf;
		else if (temp->next[i] != nullptr && tempmaxleaf->freq == maxleaf->freq)
			if(tempmaxleaf->word.compare(maxleaf->word) < 0) 
				maxleaf = tempmaxleaf;
	return maxleaf;
}

void init_trie(trie* root)
{
	trie* temp = root;
	string str, str_org;
	int freq;
	cin >> str;
	cin >> freq;
	str_org = str;
	while (str.size() != 0)
	{
		while (temp->next[str.front() - 'A'] != nullptr)
		{

			temp = temp->next[str.front() - 'A'];
			str = str.substr(1, str.size());
		}

		(temp->next[str.front() - 'A'] = new trie())->ch = str.front();
		temp = temp->next[str.front() - 'A'];
		str = str.substr(1, str.size());
	}
	temp->freq = freq;
	temp->word = str_org;
}

int get_min_tap(trie* root, string str)
{
	trie* temp = root;
	trie* temp1 = root;
	string str_org = str;
	int tap = 0;
	while (str.size() != 0 && temp->next[str.front() - 'A'] != nullptr)		//사전에 있는지 검사
	{
		temp = temp->next[str.front() - 'A'];
		str = str.substr(1, str.size());
	}
	//이때 temp는 leaf
	if (str.size() == 0)		//사전에 존재
	{
		str = str_org;

		while (str.size() != 0)
		{

			char ch = str.front();
			str = str.substr(1, str.size());
			tap++;
			trie* maxleaf = temp;
			maxleaf = dfs(temp1->next[ch - 'A'], maxleaf);
			if (str.size() != 0 && maxleaf == temp)
				return tap + 1;
			temp1 = temp1->next[ch - 'A'];
		}



	}
	else						//사전에 존재하지 않음
		return str_org.size();
	return tap;
}




int main()
{
	int C;
	cin >> C;
	while (C--)
	{
		int N, M, tap = 0;
		cin >> N >> M;
		trie root;
		for (int i = 0; i < N; i++)
		{
			init_trie(&root);		//트라이 만드는 함수
		}
		for (int i = 0; i < M; i++)
		{
			string tempstr;
			cin >> tempstr;
			tap += get_min_tap(&root, tempstr);
		}

		cout << tap + M - 1 << endl;
	}

}
