# Code Cleaning: A Refactoring Example

based on code by Wouter Lagerweij\
adapted by Arno Hollosi

More information:
* https://www.lagerweij.com/2011/05/28/code-cleaning-a-refactoring-example-in-50-easy-steps/
* https://www.lagerweij.com/2011/06/08/code-cleaning-how-tests-improve-code/

---

The main class is ConfirmationLetterTally. This one should be refactored.
All other classes are just dummy classes, so that there are no Java errors.
There's a single test too, just to give some idea about what the function is all about.

We assume that this class is part of some financial application that deals
with recorded bank transfers in three different currencies. The tallies are
reported in a confirmation letter to the customer. 
 
You are tasked with adding two more currencies:
British Pound (GBP), and Japanese Yen (JPY).

In doing so, you should refactor/clean up the class. Also, write more tests!
We are sure there might be some problems lurking somewhere.

Refactoring other classes is fair game. We assume that changes to classes
outside this example repository are easy to make.