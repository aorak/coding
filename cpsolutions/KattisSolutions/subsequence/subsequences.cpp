#include <iostream>
#include <string>
#include <map>
using namespace std;

// name: Aldiyar Orak
// Code can be reproduced

int main(){
	int number = 0;
    int quint = 0;
    int sequence[number + 1];
    int counter = 0;
    map <long long, int> longest;
	cin >> number;
	for(int i = 0; i < number; i++){
		cin >> quint;
        sequence[0] = 0;
        longest[0] = 1;
		for(int j = 1; j <= quint; j++) {
			cin >> sequence[j];
            sequence[j] += sequence[j - 1];
        }
		for(int j = 1; j <= quint; j++){
			counter += longest[sequence[j] - 47];
			longest[sequence[j]]++;
		}
		cout << counter << "\n";
	}
}