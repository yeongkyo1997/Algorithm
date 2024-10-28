#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <utility>

using namespace std;

void generateDiscounts(int m, vector<vector<int>> &allDiscounts) {
    int total = pow(4, m); 
    for(int num = 0; num < total; ++num){
        int tmp = num;
        vector<int> discounts;
        for(int i = 0; i < m; ++i){
            int discount = tmp % 4;
            tmp /= 4;
            switch(discount){
                case 0: discounts.push_back(10); break;
                case 1: discounts.push_back(20); break;
                case 2: discounts.push_back(30); break;
                case 3: discounts.push_back(40); break;
            }
        }
        allDiscounts.push_back(discounts);
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    int n = users.size();
    int m = emoticons.size();
    vector<vector<int>> allDiscounts;
    generateDiscounts(m, allDiscounts);
    
    int max_subscribers = -1;
    int max_sales = -1;
    
    for(auto &discounts : allDiscounts){
        int subscribers = 0;
        long long sales = 0;
        for(auto &user : users){
            int user_discount = user[0];
            int user_min_purchase = user[1];
            long long total = 0;
            for(int i = 0; i < m; ++i){
                if(discounts[i] >= user_discount){
                    long long discounted_price = emoticons[i] * (100 - discounts[i]) / 100;
                    total += discounted_price;
                }
            }
            if(total >= user_min_purchase){
                subscribers++;
            }
            else{
                sales += total;
            }
        }
        if(subscribers > max_subscribers){
            max_subscribers = subscribers;
            max_sales = sales;
        }
        else if(subscribers == max_subscribers){
            if(sales > max_sales){
                max_sales = sales;
            }
        }
    }
    
    return {max_subscribers, (int)max_sales};
}