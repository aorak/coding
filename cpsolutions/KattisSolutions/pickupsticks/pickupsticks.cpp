#include <iostream>
#include <vector>
#include <queue>

// name: Aldiyar Orak
// this code can be reproduced

using namespace std;

int main() {
    int sticks, lines;
    cin >> sticks >> lines;
    vector< vector<int> > vec1(sticks + 1);
    vector<int> vec2(sticks + 1, 0);
    for(int i = 0; i < lines; i++) {
        int a, b;
        cin >> a >> b;
        vec1[a].push_back(b);
        vec2[b]++;
    }
    queue<int> que;
    for(int i = 1; i <= sticks; i++) {
        if(vec2[i] == 0) {
            que.push(i);
        }
    }
    vector<int> ingame;
    while(!que.empty()) {
        int current = que.front();
        que.pop();
        ingame.push_back(current);
        for(int i = 0; i < vec1[current].size(); i++) {
            vec2[vec1[current][i]]--;
            if(vec2[vec1[current][i]] == 0) {
                que.push(vec1[current][i]);
            }
        }
    }
    if(ingame.size() == sticks) {
        for(int i = 0; i < ingame.size(); i++) {
            cout << ingame[i] << endl;
        }
    }
    else {
        cout << "IMPOSSIBLE" << endl;
    }
}