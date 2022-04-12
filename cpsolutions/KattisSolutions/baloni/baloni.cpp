#include <bits/stdc++.h>

using namespace std;

int main() {

	string line;
	int counter = 0;
	while (getline(cin, line)) {
		vector<string> words;
		words.push_back(line);
		if (counter++) 
            cout << endl;

		while(getline(cin, line) && line.length()) {
			words.push_back(line);
		}

		size_t max_len = 0;
		for (string& l : words) {
			max_len = max(max_len, l.length());
			reverse(l.begin(), l.end());
		}

		sort(words.begin(), words.end());

		for (string &word : words) {
			reverse(word.begin(), word.end());
			for (int i = word.length(); i < max_len; i++) {
                cout << ' ';
            }
			cout << word << endl;
		}
	}
	return 0;
}