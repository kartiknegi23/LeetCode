class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);

        StringBuilder bin = new StringBuilder();
        bin.append(str); 

        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='0')
            bin.setCharAt(i, '1');

            else 
            bin.setCharAt(i, '0');
        }

        String complement = bin.toString();

        int result = Integer.parseInt(complement, 2);

        return result;
    }
}