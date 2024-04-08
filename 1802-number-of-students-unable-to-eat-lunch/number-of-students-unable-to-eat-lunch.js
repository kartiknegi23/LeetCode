/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let counter = 0;

    while(students.length>0 && counter<students.length){

        if(students[0]===sandwiches[0])
        {
            students.shift();
            sandwiches.shift();
            counter = 0;
        }

        else{
            students.push(students.shift());
            counter++;
        }
    }
    return students.length;
};