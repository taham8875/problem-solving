class Solution {
   public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;

        map<char, int> frequency1;
        map<char, int> frequency2;

        for (char &character : s) {
            frequency1[character]++;
        }
        for (char &character : t) {
            frequency2[character]++;
        }

        if (frequency1.size() != frequency2.size()) return false;

        for (const pair<char, int> &i : frequency1) {
            char character = i.first;
            int frequency = i.second;
            if (frequency2[character] != frequency) return false;
        }

        return true;
    }
};