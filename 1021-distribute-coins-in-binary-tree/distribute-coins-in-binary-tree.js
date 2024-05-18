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

function dfs(node, context) {
    if (node === null)
        return [0, 0];

    let left = dfs(node.left, context);
    let right = dfs(node.right, context);

    let n = left[0] + right[0] + 1;
    let coins = left[1] + right[1] + node.val;

    context.ans += Math.abs(coins - n);

    return [n, coins];
}

var distributeCoins = function (root) {
    const context = { ans: 0 };  /// CLOSURE ///
    dfs(root, context);
    return context.ans;
};
