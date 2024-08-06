class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        int count=0;

        for(int i=0;i<word.length();i++){
            hashmap.put(word.charAt(i), hashmap.getOrDefault(word.charAt(i), 0)+1);
        }

        List<Map.Entry<Character, Integer>> entrylist = new ArrayList<>(hashmap.entrySet());

        entrylist.sort((a,b)->{
            return b.getValue()-a.getValue();
        });

        Map<Character, Integer> sortedmap = new LinkedHashMap<>();

        for(Map.Entry<Character, Integer> entry : entrylist){
            sortedmap.put(entry.getKey(), entry.getValue());
        }

        int unique = 0;
        for(Map.Entry<Character, Integer> entry : sortedmap.entrySet()){
            int frequency = entry.getValue();
            if(unique<8){
                result+=frequency;
                unique++;
            }
            else if(unique>=8 && unique<16){
                frequency*=2;
                result+=frequency;
                unique++;
            }
            else if(unique>=16 && unique<24){
                frequency*=3;
                result+=frequency;
                unique++;
            }

            else
            {
                frequency*=4;
                result+=frequency;
                unique++;
            }
        }
        return result;
    }
}