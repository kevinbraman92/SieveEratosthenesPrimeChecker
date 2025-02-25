# SieveEratosthenesPrimeChecker
This program implements the Sieve of Eratosthenes algorithm with a complete user interface. 

To run simply run Main.java after compiling. The file will handle everything else. Make sure to have all the files in the same directory for the program to work correctly.

The program implementation is as follows: Main.java calls an object of the UserInterface class. The UserInterface class encapsulates the MyNumber class that implements the algorithm. UserInterface creates an object of the MyNumber class and handles the user commands by calling the appropriate method of the MyNumber class.  

The program supports the following commands: 

Welcome: Will reprint the welcome messages.
Check Prime: Will ask for a number and check if it is prime as well as how many prime numbers exist from 2 to that number.
Help: Will output the commands list.
Exit: Will exit the program.
