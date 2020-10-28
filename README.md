# Shopping-Basket-Experiment
Experiment 1: Unit Testing
In this experiment, you will use some code and write Unit Tests for one of the classes. The
code is for a shopping system. You will focus on the Basket part of the shopping system.
You have been given code for the following classes:
• Basket – Represents a collection of Basket Items. There are operations to add
products into the basket, remove products from the basket, get the total cost of the
basket and pay for the basket. Once a basket has been paid for, you cannot add or
remove items from the basket.
• BasketItem – This contains a Product that is in the basket and the quantity of the
product that is in the basket. It can calculate the cost of the item, which is the price
of the product * the quantity.
• Discount – This represents a possible discount that can be used with the basket. A
discount is specific to a product.
• PaymentResult – Returned from the pay() method in Basket. It indicates if the
payment was successful. If it was, then it will specify if any change is returned. If the
payment wasn’t successful, then the change value will be 0. There will also be a
string message.
• Product – Represents something that can be purchased in the system. It has a name
and a price.
• Shop – This is a very simple class. It includes a main() method that shows one way to
use the code. This is to help you understand it. Do not use the main method for your
tests. 
