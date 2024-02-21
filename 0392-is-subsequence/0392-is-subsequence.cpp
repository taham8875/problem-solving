class Solution {
   public:
    bool isSubsequence(string s, string t) {
        // two pointers
        int ptr1 = 0;
        int ptr2 = 0;
        int number_of_matches = 0;
        while (ptr1 < (int)s.size() && ptr2 < (int)t.size()) {
            if (s[ptr1] == t[ptr2]) {
                ptr1++;
                ptr2++;
                number_of_matches++;
            } else {
                ptr2++;
            }
        }
        return (number_of_matches == s.size());
    }
};