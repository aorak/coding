#include <vector>
#include <iostream>


using namespace std;

vector<int> vec;
vector<int> vec1;

int main(){
    int n;
    cin >> n;
    int i;
    for( i = 0; i < n; i++){
        int temp;
        cin >> temp;
        vec.push_back(i + 1);
        vec1.push_back(temp);
    }
    int overall = n;
    int counter = 0;
    for(i = 0; i < n; i++){
        int cur = ( vec1[counter] - 1) % overall;
        cur = (cur + counter) % overall;
        vector<int>::iterator iter = vec.begin() + cur;
        vec.erase(iter);
        iter = vec1.begin() + cur;
        vec1.erase(iter);
        counter = (cur + 1) % overall;
        if(counter > cur){
            counter--;
        }
        overall--;

    }
    cout<<vec[0];
}
