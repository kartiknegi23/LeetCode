class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String>set = new HashSet<>();
        Arrays.sort(folder, (a,b)->{
            return a.length()-b.length();
        });
        List<String> list = new ArrayList<>();
        for(int i=0;i<folder.length;i++){
            String str = folder[i];
            boolean flag = false;

            for(int j=str.length()-1;j>=0;j--){
                if(str.charAt(j)=='/'){
                    String substr = str.substring(0, j);
                    if(set.contains(substr)){
                        flag = true;
                        break;
                    }
                }
            }

            if(flag==false){
                list.add(str);
            }

            set.add(str);
        }

        return list;
    }
}