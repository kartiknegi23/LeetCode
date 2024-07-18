class Solution {
    public int countPairs(TreeNode root, int distance) {
        return countPairsHelper(root, distance)[11];
    }
    private int[] countPairsHelper(TreeNode currNode, int distLimit){
        int distNodeCntMp[] = new int[12];
        if(currNode == null)return distNodeCntMp;
        if(currNode.left == null && currNode.right == null){
            distNodeCntMp[0]++;
            return distNodeCntMp;
        }
        int leftDistNodeCntMp[] = countPairsHelper(currNode.left, distLimit);
        int rightDistNodeCntMp[] = countPairsHelper(currNode.right, distLimit);
        
        int totalGoodPairsTillNow = leftDistNodeCntMp[11] + rightDistNodeCntMp[11];
        distNodeCntMp[11] += totalGoodPairsTillNow;

        for(int dist = 0; dist < 10; dist++){
            distNodeCntMp[dist + 1] += leftDistNodeCntMp[dist] + rightDistNodeCntMp[dist];
        }
        for(int dist1 = 0; dist1 <= distLimit; dist1++){
            for(int dist2 = 0; dist2 <= distLimit; dist2++){
                if(dist1 + dist2 + 2 <= distLimit){
                    distNodeCntMp[11] += leftDistNodeCntMp[dist1] * rightDistNodeCntMp[dist2];
                }
            }
        } 
        return distNodeCntMp;
    }
}