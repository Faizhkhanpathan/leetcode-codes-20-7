/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        return `Hello World`
    }
};
const result = createHelloWorld();
console.log(result());


/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */