class Solution {
    public boolean isSet(int x, int bit){
        return (x & (1<<bit)) != 0;
    }

    public int setBit(int x, int bit){
        return x | (1<<bit); 
    }

    public int unSetBit(int x, int bit){
        return x & ~(1<<bit);
    }

    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int setBitsRequired = Integer.bitCount(num2);
        int setBitCount = Integer.bitCount(num1);

        int bit = 0;
        if(setBitsRequired < setBitCount){
            while(setBitsRequired < setBitCount){
                if(isSet(x, bit))
                {
                    x = unSetBit(x, bit);
                    setBitCount--;
                }
                bit++;
            }
        } 
        else if(setBitsRequired > setBitCount){
            while(setBitsRequired > setBitCount){
                if(!isSet(x, bit)){
                    x = setBit(x, bit);
                    setBitCount++;
                }
                bit++;
            }
        }
        return x;
    }
}