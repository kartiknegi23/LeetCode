/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let currentcount = init;
    return {
        increment : function(){
            currentcount++;
            return currentcount;
        },

        decrement : function(){
            currentcount--;
            return currentcount;
        },

        reset : function(){
            currentcount = init;
            return currentcount;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */