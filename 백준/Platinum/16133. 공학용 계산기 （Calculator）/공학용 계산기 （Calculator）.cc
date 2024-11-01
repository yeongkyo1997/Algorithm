#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

struct Parser
{
    string s;
    int pos;

    Parser(string expr) : s(expr), pos(0) {}

    char current_char()
    {
        if (pos < s.size())
            return s[pos];
        return '\0';
    }

    void consume_char()
    {
        if (pos < s.size())
            pos++;
    }

    void expect(char c)
    {
        if (current_char() == c)
        {
            consume_char();
        }
    }

    ll parse_expr()
    {
        ll val = parse_term();
        while (current_char() == '+' || current_char() == '-')
        {
            char op = current_char();
            consume_char();
            ll rhs = parse_term();
            val = op == '+' ? val + rhs : val - rhs;
        }
        return val;
    }

    ll parse_term()
    {
        ll val = parse_factor();
        while (current_char() == '*' || current_char() == '/')
        {
            char op = current_char();
            consume_char();
            ll rhs = parse_factor();
            val = op == '*' ? val * rhs : val / rhs;
        }
        return val;
    }

    ll parse_factor()
    {
        ll base = parse_power();
        if (current_char() == '^')
        {
            consume_char();
            ll exponent = parse_factor();
            base = power_func(base, exponent);
        }
        return base;
    }

    ll parse_power()
    {
        if (current_char() == '#')
        {
            consume_char();
            ll operand = parse_power();
            return sqrt_floor(operand);
        }
        else
        {
            return parse_root();
        }
    }

    ll parse_root()
    {
        if (current_char() == '(')
        {
            consume_char();
            ll val = parse_expr();
            expect(')');
            return val;
        }
        else
        {
            return parse_num();
        }
    }

    ll parse_num()
    {
        ll num = 0;
        while (isdigit(current_char()))
        {
            num = num * 10 + (current_char() - '0');
            consume_char();
        }
        return num;
    }

    ll power_func(ll x, ll y)
    {
        ll ret = 1;
        while (y > 0)
        {
            if (y & 1)
            {
                ret = ret * x;
            }
            x = x * x;
            y >>= 1;
        }
        return ret;
    }

    ll sqrt_floor(ll x)
    {
        double d = sqrt((double)x);
        ll res = (ll)d;
        while ((res + 1) * (res + 1) <= x)
            res++;
        while (res * res > x)
            res--;
        return res;
    }
};

int main()
{
    string expr;
    cin >> expr;
    Parser parser(expr);
    ll result = parser.parse_expr();
    cout << result << "\n";
}