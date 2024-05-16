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
 * @return {boolean}
 */

function dfs(node){
    if(node.val===0)
    return false;

    if(node.val===1)
    return true;

    let left = dfs(node.left);
    let right = dfs(node.right);


    if(node.val===2)
    return left || right;


    if(node.val===3)
    return left && right;
}

var evaluateTree = function(root) {

    return dfs(root);
};