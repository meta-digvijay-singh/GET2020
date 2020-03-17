String.prototype.repeatify = function(count) {
    if (count > 0) {
        return this.repeat(count);
    }
    return '';
} 

console.log('hello'.repeatify(10));