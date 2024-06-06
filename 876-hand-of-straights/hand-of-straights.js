/**
 * @param {number[]} hand
 * @param {number} groupSize
 * @return {boolean}
 */
var isNStraightHand = function(hand, groupSize) {
    let hashmap = new Map();

    hand.sort((a,b)=>a-b);

    for(let i=0;i<hand.length;i++){
        if(hashmap.has(hand[i]))
        hashmap.set(hand[i], hashmap.get(hand[i])+1);

        else
        hashmap.set(hand[i], 1);
    }

    console.log(hashmap);

    while(hashmap.size>0){
        let first = hashmap.keys().next().value;
        
        for(let i=0;i<groupSize;i++){
            if(!(hashmap.has(first+i)))
            {
                return false;
            }
            hashmap.set(first+i, hashmap.get(first+i)-1);

            if(hashmap.get(first+i)<1)
            hashmap.delete(first+i);
        }
    }

    return true;
};