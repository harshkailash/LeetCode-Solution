public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        List<String> helper = new ArrayList<String>();
        int curL = 0;
        for (int i = 0; i < words.length; i ++){
            int wordL = words[i].length();
            if (curL != 0){
                curL +=1;
            }
            curL += wordL;

            if (curL > L){
                curL = curL - wordL - 1;
                int num = helper.size();
                int totalSpaceNum = 0;
                int eachSpaceNum = 0;
                String eachSpace = "";
                if (num !=1) {
                    totalSpaceNum = L - curL + num - 1;
                    eachSpaceNum = totalSpaceNum / (num - 1);
                    for (int k = 0; k < eachSpaceNum; k ++){
                        eachSpace += " ";
                    }
                }
                String plusSpace = eachSpace + " ";
                //num - 1's space
                int diff = totalSpaceNum - eachSpaceNum *(num-1);

                String add = "";
                for (int j = 0; j < helper.size(); j ++){
                    if (j == 0){
                        add +=helper.get(j);
                    }
                    else if (j <= diff){
                        add = add + plusSpace + helper.get(j);
                    }
                    else{
                        add = add + eachSpace + helper.get(j);
                    }
                }
                addRes(res, L, add);
                helper.clear();
                curL = 0;
                i --;
            }
            else if (curL == L){
                helper.add(words[i]);
                String add = "";
                for (int j = 0; j < helper.size(); j ++){
                    if (j == 0){
                        add +=helper.get(j);
                    }
                    else{
                        add = add + " " + helper.get(j);
                    }
                }
                addRes(res, L, add);
                helper.clear();
                curL = 0;
            }
            else{
                //curL < L
                helper.add(words[i]);
            }
        }//for i

        if (!helper.isEmpty()){
            String add = "";
            for (int k = 0; k < helper.size(); k ++){
                if (k == 0){
                    add += helper.get(k);
                }
                else{
                    add = add + " " + helper.get(k);
                }
            }
            addRes(res, L, add);
        }
        return res;
    }
    private void addRes(List<String> res, int L, String add){
        int append = L - add.length();
        for (int k = 0; k < append; k ++){
            add += " ";
        }
        res.add(add);
    }
}