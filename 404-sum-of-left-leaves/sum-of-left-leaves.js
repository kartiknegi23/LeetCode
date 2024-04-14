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
    // Initialize the sum
    let sum = 0;
    
    // Define a recursive function for depth-first traversal
    const dfs = (node, isLeft) => {
        // If the node is null, return
        if (!node) return;
        
        // If the node is a leaf node and a left child, add its value to the sum
        if (!node.left && !node.right && isLeft) {
            sum += node.val;
        }
        
        // Recursively traverse the left and right subtrees
        dfs(node.left, true);   // For the left child, update isLeft to true
        dfs(node.right, false); // For the right child, isLeft remains false
    };
    
    // Start the depth-first traversal from the root with isLeft set to false
    dfs(root, false);
    
    // Return the sum of left leaves
    return sum;
};