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
 * @param {number} target
 * @return {TreeNode}
 */

function dfs(node,target){
    if(node===null){
        return null;
    }

    node.left = dfs(node.left,target);
    node.right = dfs(node.right, target);

    if(node.right===null && node.left===null && node.val===target)
    {   
        node=null;
    }

    return node;
}


var removeLeafNodes = function(root, target) {
    
    
    return dfs(root,target);


};