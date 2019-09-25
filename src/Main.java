// Lecture 6
// Conditionals and loops

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /* Boolean statements
        == - equal to (when used on objects this will check the pointer value)
        != - not equal to
        < - less than
        > - greater than
        <= - less than or equal
        >= - greater than or equal

        note == is a comparator = is an assignment
         */

        if(1 > 0){ // checks if 1 is greater than 0
            System.out.println("This statement is true");
        }

        if(true){
            System.out.println("Automatically evaluates true");
        }

        // age example
        final int MINOR = 21;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scan.nextInt();

        System.out.println("You entered: " + age);

        if (age<MINOR){ // This if statement does not need the curly braces due to only one line
            System.out.println("You are a minor");
        }
        System.out.println("Age is a state of mind");

        /* Logical operators have lower precedence than the relational operators above
        ! - not The not operator has the highest precedence of these operators
        && - and
        || - or
         */

        if(1>0 && !(1<0)){ // && means both statements must evaluate true
            System.out.println("Not reverses the condition. False statements become true and true become false");
        }
        // the && and || operators will evaluate left to right, should the statement evaluate true on the first term the
        // second term is not checked
        // for && first term = false the second term is not checked
        // for || first term = true the second term is not checked

        // if else statements
        // the else statement only is executed if the statement is false
        if (1<0){
            System.out.println("This statement is true");
        }
        else{ // 1 is not less than 0 so the output of these two is the below out
            System.out.println("This statement is false");
        }

        // Wages example

        final double RATE = 8.25;
        final int STANDARD = 40;

        double pay = 0.0;

        System.out.println("Enter the hours worked: ");
        int hours = scan.nextInt();

        System.out.println(); // creates a new line

        // pay overtime if pay is at time and a half

        if (hours > STANDARD){ // overtime for > 40 hours
            pay = STANDARD * RATE + (hours - STANDARD) * (RATE * 1.5);
        }
        else{ // straight time for less than 40 hours
            pay = hours * RATE;
        }

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Gross earnings: " + fmt.format(pay));

        // if else statement
        // sometimes there are multiple successive checks to be made and a single if-else will not be enough

        if(1<0){
            System.out.println("math is broken");
        }
        else if(1>2){ // only checked if the first level is false
            System.out.println("math is really broken");
        }
        else if(1 == 5){ // only checked if the two above are false
            System.out.println("math has given up");
        }
        else{ // what is run if everything else is false
            System.out.println("Math is still working");
        }

        // nested if statements
        // these are used to evaluate multiple true statements

        if (1 > 0){
            if (1 < 2){ // only ran if the outer if evaluates true
                System.out.println("math is still good");
            }
            else{ // first check true, second check false
                System.out.println("math is a bit broken");
            }
            // statements inside of the upper if statements are still ran when there are nested statements
            System.out.println("This statement still runs after the nested if");
        }
        else { // first statement false, second statement not checked
            System.out.println("first if statement was false");
        }

        // comparing data
        // the == operator can provide unexpected results
        // when comparing decimal values the == will nearly never work
        // this is due to the binary representation may not have been stored exactly the same

        // the right way to check equal for decimals

        // we can decide how close is close enough by using a tolerance check
        if (Math.abs(1.53-1.531111) < .1){ // (difference) < (tolerance)
            System.out.println("not exactly equal but close enough");
        }

        // comparing characters
        // characters are compared using their unicode values
        /* each character has a unicode integer value
        0-9 = 48-57
        A-Z = 65-90
        a-z = 97-122
         */

        // remembering that strings are objects we can use the "equals" method to compare them

        String name1 = "Bob";
        String name2 = "bob";

        if (name1.equals(name2)){ // this will be false because b != B
            System.out.println("The strings are exactly equal");
        }
        else{
            System.out.println("the names are not exactly equal");
        }
        // for string comparisons you will need to decide if you want case sensitive checking
        // if case does not matter compare their value sent to all one case

        // the compareTo method is more precise
        int compared = name1.compareTo(name2);
        // compareTo returns 3 different cases
        /*
        0 if they are exactly equal
        negative value if name1 < name2
        positive value if name1 > name2
         */
        System.out.println("Two strings compared: "+ compared);

        // repetition statements
        // while - checks if the case is true then operates what is inside until no longer true
        // do - discussed next chapter
        // for - discussed next chapter

        /*
        while (condition){
            statement
        }
         */

        int count = 1;
        while (count <=5){ // checks if count is <= 5 and runs the loop
            System.out.println(count); // outputs the value of count
            count++; // increments count by 1
        } // returns to top of loop and checks condition again


        // average example

        int sum = 0, value, counter = 0;
        double average;

        System.out.println("Enter an integer (0 to quit): ");
        value = scan.nextInt();

        while(value!=0){ // 0 is called a sentinal value it is the exit condition
            counter++;
            sum += value;
            System.out.println("The sum so far is: " + sum);

            // since we are inside the loop we reinitialize the user input
            System.out.println("Enter an integer (0 to quit): ");
            value = scan.nextInt(); // gets the next integer
        } // when the user finally enters 0 the loop will exit
        System.out.println();
        if(counter == 0){
            System.out.printf("No values we entered");
        }
        else{
            average = (double)sum/count; // have to cast since it is integer/integer
            DecimalFormat fmt2 = new DecimalFormat("0.###");
            System.out.println("The average is: " + fmt2.format(average));
        }

        // input validation
        /*
        Generally it is a good idea to check that the input is of the expected format
        before passing it to the program, this makes the program less prone to error
        this is usually done in a while loop to allow for multiple errors
         */

        // infinite loops will break your program
        // Control-C will interrupt your program should you make that error
        /*
        while(1 < 0){ this will never be false and will run forever
            statement
        }
        */

        // palindrome tester
        // This method will NOT ignore spaces or punctuation
        // it could be a perfect palindrome but spaces or punctuation break it

        String str, another = "y";
        int left, right;

        // equalsIgnoreCase() is a clean way of allowing for Y or y
        while (another.equalsIgnoreCase("y")) {
            System.out.println("Enter a palindrome to check: ");
            str = scan.nextLine();

            left = 0;
            right = str.length()-1;

            // checks characters from the outside in at the listed index
            while (str.charAt(left) == str.charAt(right) && left < right){
                left++;
                right--;
            }
            System.out.println();

            // if statement means that the while loop exited before the string comparison was done
            if (left < right){
                System.out.println("This string is not a palindrome");
            }
            else{ // all characters were checked and the while loop exited that way
                System.out.println("This string is a palindrome");
            }
            System.out.println();

            System.out.println("Test another? (y/n)");
            another = scan.nextLine(); // gets user repeat request
        }



    }
}
