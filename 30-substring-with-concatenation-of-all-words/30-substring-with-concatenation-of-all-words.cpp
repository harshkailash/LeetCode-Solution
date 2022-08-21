class Solution {
public:
    bool checkIfSubsctring(string& s, int& i , int& maxL, int& wordsLength, unordered_map<string, int> wordCount )
    {
        for(int j = i; j < i+wordsLength; j += maxL)
        {
            string subWord = s.substr(j, maxL);
            
            if(!wordCount.count(subWord) or wordCount[subWord]-- == 0)
            {
                return false;
            }
        }
        
        return true;
    }
    
    vector<int> findSubstring(string s, vector<string>& words) {
        
        unordered_map<string, int> wordCount;
        int maxL = words[0].size();
        int wordsLength = maxL * words.size();
        
        for(auto& word: words)
        {
            wordCount[word]++;
        }
        
        int i {0};
        vector<int> res;
        
        while( i + wordsLength <= s.size() )
        {
            if(checkIfSubsctring(s, i, maxL, wordsLength, wordCount))
            {
                res.push_back(i);
            }
               
            i++;
       }
               
        return res;
    }
};