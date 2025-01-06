class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        l = len(boxes)
        ans = [0] * l
        before = 0
        after = 0
        num = 0
        for i in range(l):
            if boxes[i] == "1":
                after += 1
                num += i
        for i in range(l):
            ans[i] = num
            if boxes[i] == "1":
                before += 1
                after -= 1
            num += before - after
        return ans