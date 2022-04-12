#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
struct A { int weight[2]; };

bool comparator(A first, A second) {
    if(first.weight[1] == second.weight[1]) {
        return first.weight[0] < second.weight[0];
    }
    return first.weight[1] < second.weight[1];
}
int main() {
    int num;
    cin >> num;
    vector<A> minions;
    for(int i = 0; i < num; i++) {
        A temp;
        cin >> temp.weight[0] >> temp.weight[1];
        minions.push_back(temp);
    }
    sort(minions.begin(), minions.end(), comparator);
    int counter = 1;
    int max = minions[0].weight[1];
    for(int i = 1; i < minions.size(); i++) {
        if(minions[i].weight[0] > max) {
            max = minions[i].weight[1];
            counter++;
        }
    }
    cout << counter << endl;
}