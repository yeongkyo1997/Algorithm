#include <bits/stdc++.h>
using namespace std;

bool is_hex(char c)
{
    return ('0' <= c && c <= '9') ||
           ('A' <= c && c <= 'F') ||
           ('a' <= c && c <= 'f');
}

bool is_valid_tag_name(const string &tag)
{
    if (tag.empty())
        return false;
    for (char c : tag)
    {
        if (!('a' <= c && c <= 'z') && !('0' <= c && c <= '9'))
            return false;
    }
    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string line;
    while (getline(cin, line))
    {
        stack<string> tag_stack;
        bool valid = true;
        int n = line.size();
        for (int i = 0; i < n && valid;)
        {
            char c = line[i];
            if (c == '<')
            {
                int start = i;
                int close = line.find('>', i + 1);
                if (close == string::npos)
                {
                    valid = false;
                    break;
                }
                string tag_content = line.substr(i + 1, close - i - 1);
                if (tag_content.empty())
                {
                    valid = false;
                    break;
                }
                if (tag_content[0] == '/')
                {
                    // Closing tag
                    string closing_tag = tag_content.substr(1);
                    if (!is_valid_tag_name(closing_tag))
                    {
                        valid = false;
                        break;
                    }
                    if (tag_stack.empty() || tag_stack.top() != closing_tag)
                    {
                        valid = false;
                        break;
                    }
                    tag_stack.pop();
                }
                else
                {
                    bool self_closing = false;
                    if (tag_content.size() >= 1 && tag_content.back() == '/')
                    {
                        self_closing = true;
                        tag_content.pop_back();
                        // Remove possible trailing whitespace before '/'
                        while (!tag_content.empty() && tag_content.back() == ' ')
                            tag_content.pop_back();
                        if (tag_content.empty())
                        {
                            valid = false;
                            break;
                        }
                    }
                    string opening_tag = tag_content;
                    if (!is_valid_tag_name(opening_tag))
                    {
                        valid = false;
                        break;
                    }
                    if (!self_closing)
                    {
                        tag_stack.push(opening_tag);
                    }
                }
                i = close + 1;
            }
            else if (c == '&')
            {
                int start = i;
                int semicolon = line.find(';', i + 1);
                if (semicolon == string::npos)
                {
                    valid = false;
                    break;
                }
                string entity = line.substr(i, semicolon - i + 1);
                if (entity == "&lt;" || entity == "&gt;" || entity == "&amp;")
                {
                }
                else
                {
                    if (entity.size() >= 4 && entity[1] == 'x')
                    {
                        string hex_part = entity.substr(2, entity.size() - 3);
                        if (hex_part.empty() || hex_part.size() % 2 != 0)
                        {
                            valid = false;
                            break;
                        }
                        bool hex_valid = true;
                        for (char hc : hex_part)
                        {
                            if (!is_hex(hc))
                            {
                                hex_valid = false;
                                break;
                            }
                        }
                        if (!hex_valid)
                        {
                            valid = false;
                            break;
                        }
                    }
                    else
                    {
                        valid = false;
                        break;
                    }
                }
                i = semicolon + 1;
            }
            else
            {
                if (!(32 <= c && c <= 127))
                {
                    valid = false;
                    break;
                }
                if (c == '<' || c == '>' || c == '&')
                {
                    valid = false;
                    break;
                }
                i++;
            }
        }
        if (valid && tag_stack.empty())
        {
            cout << "valid\n";
        }
        else
        {
            cout << "invalid\n";
        }
    }
}