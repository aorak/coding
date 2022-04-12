#include <iostream>
#include <vector>
#include <string>

using namespace std;

string str;
vector<int> possibilities(101, 1);
int ans = 0;

bool isvalid() {
	bool hasL = false;
    bool isVowel = true;
	int counter = 0;
	for (char &c: str) {
		if (c == 'L') 
            hasL = true;
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			if (isVowel) 
                counter++;
			else {
				isVowel = true;
				counter = 1;
			}
		} 
        else {
			if (isVowel) {
				isVowel = false;
				counter = 1;
			} 
            else 
                counter++;
		}

		if (counter >= 3) return false;
	}
	return hasL;
}
void helper(int i) {
	if (i == str.length()) {
		if (isvalid()) {
			int count = 1;
			for (int j = 0; j < str.size(); j++) 
                count *= possibilities[j];
			ans += count;
		}
		return;
	}
	if (str[i] != '_') 
        helper(i + 1);
	else {
		str[i] = 'L';
		helper(i + 1);
		str[i] = 'B';
		possibilities[i] = 20;
		helper(i + 1);
		str[i] = 'A';
		possibilities[i] = 5;
		helper(i + 1);
		str[i] = '_';
		possibilities[i] = 1;
	}
}

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> str;
	helper(0);
	cout << ans;
}