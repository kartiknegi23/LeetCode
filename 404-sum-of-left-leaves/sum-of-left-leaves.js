/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function(root) {
    if(root===null)
    return 0;

    let arr = [];

    let sum = 0;
    let isleft = false;
    function inorder(root, isleft){
        if(root===null)
        return;

        if(root.left===null && root.right===null && isleft===true)
        sum+=root.val;


        inorder(root.left,true);
        
        inorder(root.right,false);
    }
    
    inorder(root, false);
    return sum;
};