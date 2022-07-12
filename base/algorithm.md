The goal of this assignment was to create a program loosely based on Microsoft Paint using java, it would incorporate sound OOP practices, abstraction, as well as serialization

The inputs would be the User's name, account number, and pin number

The output would be a new User 

I will most likely need multiple methods and functions for this program


Admin Menu
Goal: Admin interaction with all users on the GUI
Input: When adding a user it will be their name, account, and pin. When Deleting a user it will be their name
Output: Will either be a new user object or one less object
Steps:
    1) Load up all active users using serialization
    2) Prompt the user to login (admin has their own set of credentials seperate from other users)
    3) Prompt the Admin to select whether they want to add or delete a user

Create User
Goal: To allow the admin to produce an object of type "User"
Input: User prompted inputs
Output: User object
Steps:
    1) Prompt the user for what kind of pet they would like
    2) Prompt admin for the User's key attributes like name, account number, and pin number (Users will also be created with an arraylist parameter to store colors)
    3) Save the User object using serialization

Delete User
Goal: To delete a single User object
Input: Whichever object is selected
Output: n/a (Or the lack of one, there should be one less serialized object when all is said and done)
Steps:
    1) Load up and list all serialized User objects from file into an arraylist
    2) Prompt user for which User they intend to delete
    3) Remove object from arraylist
    4) Save current arraylist

Create Color
Goal: To allow the User to produce an object of type "Colour*"  (Note the letter u)
Input: User prompted inputs, Image file
Output: Color object
Steps:
   1) While the user is logged in they can manipulate RGB or HSV values to produce a color
   2) User can also upload an image file and use thee location of the mouse to obtain thee RGB values of a pxel
   3) Clicking on a certain JPanel will allow the user to translate these values into an object
   4) The color object can then be saved using serialization

Login Menu
Goal: Allows either a User or Admin to login to the program GUI
Input: account and in number
Output: A GUI screen, either pertaining to a User or Admin, or serialized color objects
Steps:
    1) Load in all serialized user objects into an arraylist
    2) Prompt for login credentials
       1) If Admin credentials are used, User will be taken to Admin Menu
       2) If not, User will be taken to Paint GUI
    3) Load in all serialized color objects for specific User 
    4) User is now free to create more colors and save them

