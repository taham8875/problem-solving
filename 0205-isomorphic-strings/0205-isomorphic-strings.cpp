class Solution {
   public:
    bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) return false;

        map<char, char> mp1, mp2;
        for (int i = 0; i < (int)s.size(); i++) {
            if (mp1.count(s[i]) && t[i] != mp1[s[i]]) {
                return false;
            }
            if (mp2.count(t[i]) && s[i] != mp2[t[i]]) {
                return false;
            }

            mp1[s[i]] = t[i];
            mp2[t[i]] = s[i];
        }
        return true;
    }
};