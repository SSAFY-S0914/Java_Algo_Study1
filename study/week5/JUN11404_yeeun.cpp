#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;
using ll = long long;
const int INF = 1e9;
int n, m;
int map[101][101];
void fw() {
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if(map[i][j] >= INF){
                map[i][j] = 0;
            }
            cout << map[i][j] << " ";
        }
        cout << '\n';
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            map[i][j] = INF;
            if (i == j) map[i][j] = 0;
        }
    }
        
    for (int i = 0; i < m; i++) {
        int s,e,c;
        cin >> s >> e >> c;
        map[s][e] = min(map[s][e], c); // 노선 2개 이상일수도
    }
    fw();
    return 0;
}
