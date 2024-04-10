/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function(deck) {
  deck.sort((a,b)=> a-b);
  let ans = new Array(deck.length).fill(0);
  let index = [];
  for(let i=0;i<deck.length;i++){
    index[i]=i;
  }  

  let i=0; 
  while(i<deck.length){
    ans[index[0]] = deck[i];
    index.shift();
    if(deck.length!==0)
    {
        index.push(index.shift());
    }
    i++;

  }

  return ans;
};
