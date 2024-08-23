class Solution {

    public int gcd(int a, int b){
        if(b==0)
        return a;

        return gcd(b, a%b);
    }

    public String fractionAddition(String expression) {

        int numerator=0;
        int denominator=1;
        
        int n=0;
        int d=0;
        boolean flag = false;

        char sign = '+';

        for(int i=0;i<expression.length();i++){
            if(i==0){
                if(expression.charAt(0)!='-')
                n = expression.charAt(0)-'0';

                else
                sign = '-';

            }
            else{
                if(expression.charAt(i)=='-' || expression.charAt(i)=='+')
                {   
                    if(expression.charAt(i)=='-')
                    sign = '-';
                    
                    else if(expression.charAt(i)=='+')
                    sign = '+';

                    flag = false;

                    int new_denominator = d*denominator;

                    int new_numerator = (numerator*d) + (n*denominator);

                    numerator = new_numerator;
                    denominator = new_denominator;

                    n=0;
                    d=0;
                }

                else if(expression.charAt(i)=='/')
                flag = true;

                else if(Character.isDigit(expression.charAt(i))){
                    if(flag==false){
                        n = Math.abs(n)*10 + (expression.charAt(i)-'0');
                        if(sign=='-')
                        n = -n;
                    }
                    else{
                        d = d*10 + (expression.charAt(i)-'0');
                    }
                }

            }
        }

        int new_denominator = d*denominator;

        int new_numerator = (numerator*d) + (n*denominator);

        numerator = new_numerator;
        denominator = new_denominator;

        if(numerator==0)
        return "0/1";

        int divisor = gcd(Math.abs(numerator), denominator);

        numerator/=divisor;
        denominator/=divisor;

        StringBuilder str = new StringBuilder();
        str.append(numerator);
        str.append("/");
        str.append(denominator); 
        return str.toString();
    }
}