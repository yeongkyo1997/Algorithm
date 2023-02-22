#include<stdio.h>
#include<iostream>
#include<stack>
#include<string>
using namespace std;

bool oper(char ch) {
	if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
		return true;
	else
		return false;
}

int main(void) {

	int n;
	string str;
	int alphabet[26];
	stack<double> st;

	cin >> n >> str;

	for (int i = 0; i < n; i++)
		cin >> alphabet[i];

	for (int i = 0; i < str.length(); i++) {
		if (oper(str[i])) {
			double a, b, c;

			a = st.top();
			st.pop();
			b = st.top();
			st.pop();

			if (str[i] == '+')
				c = b + a;
			else if (str[i] == '-')
				c = b - a;
			else if (str[i] == '*')
				c = b * a;
			else
				c = b / a;

			st.push(c);
		}
		else
			st.push(alphabet[str[i] - 'A']);
	}
	printf("%.2f", st.top());
}