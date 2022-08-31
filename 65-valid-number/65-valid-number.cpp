class Solution {
    
    bool isInt(string s)
    {
        // first char can be + or -
        // rest have to be digits 
        
        int n = s.length();
        int si = 0;
        
        if(n == 0) return false;
        
        if(s[0] == '+' || s[0] == '-') si = 1;
        
        if(n==1 && si==1) return false;
        // "+" or "-"
        
        for(int i = si;  i<n ; i++)
        {
            if(s[i] >= '0' && s[i] <= '9') continue;
            
            return false;
        }
        
        return true;
    }
    
    bool isDec(string s)
    {
        int n = s.length();
        int si =  0; 
        if(n==0) return false;
        if(s[0] == '+' || s[0] == '-') si = 1;
        if(n==1 && si==1) return false;
        
        // can be 
        // .123  or  123.  or 123.123
        // can not be .
        // exactly 1 '.'
        
        bool dot = false;
        if(si == n-1 && s[si] == '.') return false;
        
        for(int i = si ; i<n ; i++)
        {
            if(s[i] >= '0' && s[i] <= '9') continue;
            if(s[i] == '.')
            {
                if(dot) return false; // it means one . was already there , and having multiple dots is not allowed
                dot = true;
                continue;
            
            }
            return false;
        }
        
        return true;
    }
    
    
    bool valid(string s )
    {
        // can only contain e , E
        // .
        // + , -
        // digits

        for(char c : s)
        {
            if(c=='E' || c=='e' || c=='.')continue;
            if(c=='+' || c=='-')continue;
            if('0' <= c && c <= '9') continue;
            
            return false;
        }
        return true;
    }
    
public:
    bool isNumber(string str) {
        
        if(!valid(str)) return false;
        
        
        string f , s;
        // f = string before e  , s = string after e
        // fes
        
        bool flag = false;
        // we want only one e or E , so this flag will keep track of it

        for(char c : str)
        {
            if(c=='e' || c=='E') {
                if(flag == false) flag = true;
                else return false; // multiple e, E , number must have exactly 1 e or E 

            }
            else {
                if(flag) s += c;
                else f += c;
            }
        }
        
        // first part has to be decimal or int
        if(!isDec(f) && !isInt(f)) return false;
        
        if(flag==false) return true;
        // it means no e was there and in the above check we have validated that f was either a decimal or integer so answer is true
        
        // second part has to be an intger
        if(!isInt(s)) return false;
        
        return true ;
        
        
        // tc : O(n) + O(n) + O(n) : valid() + one whole iteration to form f and s, then two iterations on f isInt , isDec and 1 iteration on s , isInt
        
        // over all tc : O(n) , sc : O(1)
    }
};