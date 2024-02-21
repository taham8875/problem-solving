class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int end = 0;
        int len = 0;
        map<char, int> char_table;
        for (; end < (int)s.size(); end++) {
            if (char_table.count(s[end]) && char_table[s[end]] >= start) {
                start = char_table[s[end]] + 1;
            }
            char_table[s[end]] = end;
            len = max(len, end - start + 1);
        }
        return len;
    }
};