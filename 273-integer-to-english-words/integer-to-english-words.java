class Solution {
    Map<Integer, String> ones;
    
    Map<Integer, String> teens;
    
    Map<Integer, String> belowhundred;

    public String convert(int num){
        if(num==0)
        return "Zero";

        if(num<10)
        return ones.get(num);

        if(num<20)
        return teens.get(num);

        if(num<100)
        return belowhundred.get(num/10) + (num%10 != 0 ? " "+convert(num%10) : "");

        if(num<1000)
        return convert(num/100) + " Hundred" + ((num%100) !=0 ? " " +convert(num%100) : ""); 

        if(num<1000000) // 95001
        return convert(num/1000) + " Thousand" + ((num%1000) != 0 ? " " + convert(num%1000) : "");

        if(num<1000000000) // 1234567 
        return convert(num/1000000) + " Million" + ((num%1000000) != 0 ? " " + convert(num%1000000) : "");

        return convert(num/1000000000) + " Billion" + ((num%1000000000) != 0 ? " " + convert(num%1000000000) : "");
        
    }

    public String numberToWords(int num) {
        ones = new HashMap<>();
        ones.put(1,"One");ones.put(2, "Two");ones.put(3, "Three");ones.put(4, "Four");ones.put(5, "Five");ones.put(6, "Six");ones.put(7, "Seven");ones.put(8, "Eight");ones.put(9, "Nine"); 

        teens = new HashMap<>();
        teens.put(10, "Ten");teens.put(11, "Eleven");teens.put(12, "Twelve");teens.put(13, "Thirteen");teens.put(14,"Fourteen");teens.put(15,"Fifteen");teens.put(16,"Sixteen");teens.put(17,"Seventeen");teens.put(18,"Eighteen");teens.put(19,"Nineteen");

        belowhundred = new HashMap<>();
        belowhundred.put(2,"Twenty");belowhundred.put(3,"Thirty");belowhundred.put(4,"Forty");belowhundred.put(5,"Fifty");belowhundred.put(6,"Sixty");belowhundred.put(7,"Seventy");belowhundred.put(8,"Eighty");belowhundred.put(9,"Ninety");

        return convert(num);
    }
}