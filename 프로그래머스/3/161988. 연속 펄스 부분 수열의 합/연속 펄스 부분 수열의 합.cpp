#include <string>
#include <vector>
#include <algorithm>
#include <limits>
using namespace std;

/*
 * 연속 부분합(카데인 알고리즘) 함수.
 * 주어진 벡터 arr에 대해, 가장 큰 연속 부분합을 리턴한다.
 */
long long maxSubarraySum(const vector<long long> &arr)
{
    long long currSum = 0;
    long long maxSum = numeric_limits<long long>::min();
    for (auto val : arr)
    {

        currSum = max(currSum + val, val);
        maxSum = max(maxSum, currSum);
    }
    return maxSum;
}

long long solution(vector<int> sequence)
{

    int n = sequence.size();

    vector<long long> plusMinus(n), minusPlus(n);
    for (int i = 0; i < n; i++)
    {

        if (i % 2 == 0)
        {
            plusMinus[i] = (long long)sequence[i];
            minusPlus[i] = (long long)sequence[i] * -1;
        }
        else
        {
            plusMinus[i] = (long long)sequence[i] * -1;
            minusPlus[i] = (long long)sequence[i];
        }
    }

    long long maxSumPlusMinus = maxSubarraySum(plusMinus);
    long long maxSumMinusPlus = maxSubarraySum(minusPlus);

    long long answer = max(maxSumPlusMinus, maxSumMinusPlus);
    return answer;
}
