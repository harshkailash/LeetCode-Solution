class Solution {
public:
    int longestValidParentheses(string s) {
        int n=s.length();
        vector<int>dp(n+1,0);
        stack<int>st;
        int ans=0;
        int temp=0;
        for(int i=0;i<n;i++)
        {
            if(s[i]=='(')
                st.push(i);
            else
            {
                if(!st.empty())
                {
                    int k=st.top();
                    st.pop();
                    dp[k]=(i-k+1);
                }
            }
        }
        int i=0;
        while(i<n)
        {
            if(dp[i]==0)
            {
                temp=0;
                i++;
            }
            else
            {
                temp+=dp[i];
                i+=dp[i];
            }
            ans=max(ans,temp);
        }
        ans=max(ans,temp);
        return ans;
    }
};