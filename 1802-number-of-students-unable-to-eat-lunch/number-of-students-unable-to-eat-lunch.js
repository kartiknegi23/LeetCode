/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let unableToEat = 0;
    let queue = [...students]; // Create a copy of the students array

    let index = 0;
    while (index < queue.length) {
        if (queue[index] === sandwiches[0]) {
            // If the student prefers the current sandwich, remove the sandwich
            queue.splice(index, 1);
            sandwiches.shift();
            index = 0; // Reset index to 0
        } else {
            // If the student doesn't prefer the current sandwich, move to the next student
            index++;
        }

        // Check if all students have been served a sandwich
        if (sandwiches.length === 0) {
            break;
        }
    }

    // The remaining students in the queue are unable to eat
    unableToEat = queue.length;

    return unableToEat;
}
