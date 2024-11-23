class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] result = new char[n][m];

        //Transpose//
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j]=box[j][i];
            }
        }

        //90deg rotate//
        for (int i = 0; i < result.length; i++) {
            // Convert char[] to Character[]
            Character[] rowAsList = new Character[result[i].length];
            for (int j = 0; j < result[i].length; j++) {
                rowAsList[j] = result[i][j];
            }
            
            // Reverse the List
            Collections.reverse(Arrays.asList(rowAsList));
            
            // Convert back to char[]
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = rowAsList[j];
            }
        }

        //Gravity//
        for(int j=0;j<m;j++){
            int row = n-1;
            for(int i=n-1;i>=0;i--){
                if(result[i][j]=='*'){
                    row=i-1;
                    continue;
                }

                if(result[i][j]=='#'){
                    result[i][j]='.';
                    result[row][j]='#';
                    row--;
                }

            }
        }

        return result;
    }
}