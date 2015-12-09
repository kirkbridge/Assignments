------------------------------------------------------------------------
Assignment 6 - ShippingContainers
------------------------------------------------------------------------

PROJECT TITLE: Assignment 6
PURPOSE OF PROJECT: Calculate how many boxes are required for a shipment
VERSION or DATE: November 3, 2015
HOW TO START THIS PROJECT: Using Blue Jay just run the main method
AUTHOR: Bradley Kirkbride-Taylor
USER INSTRUCTIONS: 
Follow the prompts of the program and make sure you enter values of the proper type.

To add more box types to the program you only need to change the constants that are declared at the class level.

final static int[] BOXES_SIZES = {50,20,5,1} ;

final static String[] BOX_TYPES ={"XL","L","M","S"} ;

For example if you wanted to add an XXL box type then simply add to the arrays how many items this box can 
hold and the label you want to use to represnt this new box type.


final static int[] BOXES_SIZES = {100,50,20,5,1} ;

final static String[] BOX_TYPES ={"XXL",XL","L","M","S"} ;

NOTE- The size must be added to the array from largest to smallest so if you are adding a bigger size then
it should be the first element in the array and if you are adding a size smaller than the rest it should be 
added as the last elelment of the array. Also the label for the size of box must be the same index number in the array
as the two arrays are parrallel.

That is all you need to change if you want to add another box size or even just change the existing box sizes.