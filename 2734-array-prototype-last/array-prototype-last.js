/**
//  * @return {null|boolean|number|string|Array|Object}
//  */
// Array.prototype.last = function() {
    
// };

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */

 Array.prototype.last = function() {
    return this.length === 0 ? -1 : this[this.length - 1];
};
