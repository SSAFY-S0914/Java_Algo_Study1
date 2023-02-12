#include <iostream>
#include <algorithm>
#include <queue>
#include <math.h>
using namespace std;
const int MAX = 40;
int k;
int sum = 0;
int row[MAX];

bool is_promising(int x) {
    for (int i = 0; i < x; ++i) { // 현재 row인 x 이전 줄 (윗줄들)
        if ((row[i] == row[x]) || abs(row[x] - row[i]) == abs(x - i)) {
            return false;
        }
    }
    return true;
}

void sol(int idx) {
    if (idx == k) {
        sum++;
        return;
    }
    for (int i = 0; i < k; ++i) {
        row[idx] = i; // idx번째 Row에 i번째 column에 놓기
        // 일단 row idx번째에 두고 아래에서 유망성 검사
        if (is_promising(idx)) { // idx번째 줄에 놓을 수 있다면
            sol(idx+1);// 다음줄로 넘어감
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> k;

    sol(0);
    cout << sum;
    return 0;
}

