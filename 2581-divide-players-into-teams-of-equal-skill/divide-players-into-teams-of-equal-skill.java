class Solution {
    public long dividePlayers(int[] skill) {
        int total = 0;
        for(int i=0;i<skill.length;i++){
            total+=skill[i];
        }        
        Arrays.sort(skill);
        List<int[]>list = new ArrayList<>();

        long product = skill[0]*skill[skill.length-1];
        long prev = skill[0]+skill[skill.length-1];
        for(int i=1;i<skill.length/2;i++){
            if(prev != skill[i] + skill[skill.length-1-i])
            return -1;

            product = product + (skill[i] * skill[skill.length-1-i]);
        }

        return product;

    }
}