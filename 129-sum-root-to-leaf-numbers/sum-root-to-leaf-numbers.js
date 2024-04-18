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
var sumNumbers = function(root) {
    let arr = [];
    let s = 0;

    function travel(root, s){
        if(root === null)
        return;

        s=s*10+root.val;

        console.log(s);


        if(root.left===null && root.right===null)
        arr.push(s);

        travel(root.left,s);

        travel(root.right,s);
    }

    travel(root,s);

    let sum=0;

    for(let i=0;i<arr.length;i++){
        sum+=arr[i];
    }

    return sum;
};