class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String s1;
        String s2;

        s1 = new String(sentence1);
        s2 = new String(sentence2);

        if(sentence1.length() < sentence2.length()){
            s1 = new String(sentence2);
            s2 = new String(sentence1);
        }

        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        int i=0;
        int j = str1.length-1;
        int k = 0;
        int l = str2.length-1;

        while(i<str1.length && k<str2.length && str1[i].equals(str2[k])){
            i++;
            k++;
        }

        while(l>=k && str1[j].equals(str2[l])){
            j--;
            l--;
        }

        if(l<k)
        return true;

        else
        return false;
    }
}