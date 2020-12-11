# Calculator-with-GUI

* Overview

I built a calculator that carries out binary operations by utilizing the power of a inheritance, abstract classes, and polymorphism. Dynamic Binding makes this program very flexible incase more operations were to be added in the future. 

* Implementation Details

I created multiple classes to mirror different operations such as addition, subtraction, division, multiplication etc. I used a hash map to store these classes and create instances of these classes whenever I detected specific tokens inputted such as “+”,“-“,”/”,”*”, etc. Then using a basic while loop I pushed operators and operands onto their respective stacks while making sure I stayed mindful of the order of operations. While pushing Operators and Operands onto their respective stacks I am calling each calculator.math.operators's execute method utilizing polymorphism. Implementing parenthesis was similar. I pushed an object for an open parenthesis that was just an identifier. Then when I detected a close parenthesis I would solve everything up until the open parenthesis identifier.


* Class Diagram

I attached a Class Diagram to help further explain the Implementation Details.


