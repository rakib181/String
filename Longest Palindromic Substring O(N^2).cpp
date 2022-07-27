#include<bits/stdc++.h>
using namespace std;
const int N = 1000;
int table[N + 10][N + 10]{0, 0};
string lps(string s, int n){
    int maxlen = 1, start = 0;
    for(int i = 0; i < n; i++){
        table[i][i] = 1;
    }
    for(int i = 0; i < n - 1; i++){
        if(s[i] == s[i + 1]){
            table[i][i + 1] = 1;
            start = i;
            maxlen = 2;
        }
    }
    for(int i = 3; i <= n; i++){
        for(int j = 0; j < n - i + 1; j++){
            int k = j + i - 1;
            if( table[j + 1][k - 1] && s[j] == s[k]){
                table[j][k] = 1;
                if(i > maxlen){
                    start = j;
                    maxlen = i;
                }
            }
        }
    }
    return s.substr(start,  maxlen);
}

int32_t main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    cout << lps(s, s.size());
    return 0;
}
