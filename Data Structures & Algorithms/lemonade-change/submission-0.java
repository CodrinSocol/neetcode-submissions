class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0;
        int tenCnt = 0;
        int ttyCnt = 0;

        for(int bill : bills) {
            if(bill == 20) {
                ttyCnt++;
                if(tenCnt > 0 && fiveCnt > 0) {
                    tenCnt--;
                    fiveCnt--;
                } else {
                    if(fiveCnt > 2) {
                        fiveCnt -= 3;
                    } else {
                        return false;
                    }  
                }
            }
            else if (bill == 10) {
                tenCnt++;

                if(fiveCnt > 0) {
                    fiveCnt--;
                } else {
                    return false;
                }
            } else {
                fiveCnt++;
            }
        }

        return true;
    }
}