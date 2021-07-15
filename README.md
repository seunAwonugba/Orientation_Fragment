# Orientation_Fragment
There are 3 repositories in this project
1. Add and Remove Fragment Project
2. Time Fighter game
3. keep track of Orientation changes

1. Add and Remove Fragment:
The add and remove fragment project adds and removes fragment in an activity, there are two buttons on the activity,
one adds fragments while the other removes fragments. The entery point of the code is the onCreate() method that holds the setContentView methods that helps with layout
and also a saveInstanceState:Bundle pair that holds the UI state of the app when there is a configuration or orientation change or the onDestroy() call back method is called on the app
Both buttons have a click listerner attached to them that listens when the user clicks any of the button, The button that adds fragments invokes the functionAddFragment() while the other button that removes 
fragments invokes the functionRemoveFragment(). I took advantage of the fragment manager, begin transaction and addToBackStack methods to add fragments to stacks while i used the remove fragment method to remove fragments from the activity

2. Time Fighter game
All this game does is that it listens to a click at the buttom of the page and increases its count value while there is a countdown timer that counts down from 60 to 0 in a min
The game trys to get amount of times you could tap the button within a min, then returns the count value.
This game is implemented in such a way orientation change does not affect the scores or count down timer. I took advantage of the onSaveInstanceState that stores the value, shortly before orientation change occurs
that invokes the onDestroy method, and when the onCreate() is invoked again, the program checks if values are stored in the saveInstanceState then picks up its counting from there

3. Keep track of Orientation changes
This project monitors orientation changes in the app, i took advantage of the resources.congigurtion.orientation method that returns 1, when the app is on portrait view and returns 2 when orientation changes to landscape
I stored those values in a variable, and used an if statment to check the vaues and return its corresponding orientation value. Also in this app, values dont restart due to orientation change
