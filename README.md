# LDTS_2LEIC04gr07 - Water Girl & Lava Boy

> In this two player platformer, you play as Water Girl and Lava Boy and join forces to collect all the Coins and climb up to the finish line. Water Girl is not vulnerable to the same obstacles and cannot collect the same items as Lava Boy (and vice versa) and therefore, the two players must cooperate to complete the level.
This project was developed by Manuel Silva (up202108874@up.pt) and Maria Laranjeira (up202004453@up.pt) for LDTS 2022⁄2023.

## Implemented Features

- **Keyboard Control:** Water Girl and Lava Boy movement is controlled by the players using the keyboard
- **Jumping:** Both Water Girl and Lava Boy can jump and they will both fall to the ground afterwards thanks to the implementation of gravity.
- **Collisions Detection:** Collisions are checked so that the players cannot go out of bounds and are able to stand in the different platforms and on top of each other.
- **Surfaces:** Only Water Girl can walk through water surfaces and only Lava Boy can walk through lava surfaces. 
- **Coins:** The same way, only Lava Boy can collect lava coins and only Water Girl can collect water coins.
- **FPS:** Added FPS to the game
- **KeyBoard Input:** Used Keyboard Listener to be able to press keys simultaneously.
- **Character “Animation”:**  The characters will be facing left when walking left and facing right when walking right.
- **Quit:** The game can be exited by closing the game window or clicking enter on the exit option on the menu.
- **Pause:** The game can be paused. The players can then either resume the current game or start over.
- **Monsters:** Water and Lava monsters that increase the game difficulty and require more cooperation between players by instilling more differences in Water Girl’s and Lava Boy’s properties, with only Water Girl being able to kill Lava monsters and vice versa. Monsters behave independently and randomly.
- **FinalBoss:** Intelligent monster that targets both Water Girl and Lava Boy, running after both players and shooting projectiles in their direction. Its health is displayed above its head with two blue hearts that Lava Boy must take and other two red hearts that Water Girl must take in order for it to be defeated.
- **Combat:** Water Girl and Lava boy can launch water and lava projectiles by pressing the ArrowDown key and the E key, respectively
- **Contraptions:** Buttons that trigger elevators to get to other platforms.
- **Timer:** Time counter from start of the game up until when the players reach the finish line or lose the game.
- **Game and Menu Sounds:** Added sounds to the game and menus to make everything more immersive.
- **Options:** Menu that allows the player to adjust music volume and special effects volume.
- **Stars:** Stars are displayed when the players win the game. Players get one default star for completion, two stars if all coins were collected or if the players finished the game quickly and finally three starts if all these conditions were met simultaneously. 
- **HighScore**: Player stars and completion times are stored and are listed by amount of stars and in case of tie, by completion time, displaying the best 10 scores so far.


<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209050765-2c52d162-7c38-4891-bb5a-693615b394eb.png"/>
</p>
<p align="center">
  <b><i>Img 1. Main Menu </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209050826-b751a030-86d7-4d35-8740-38a0216e0ecb.png"/>
</p>
<p align="center">
  <b><i>Img 2. Instructions Menu </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209050865-8fca8afa-c92e-4668-8bd7-ac2c9b4dee2c.png"/>
</p>
<p align="center">
  <b><i>Img 3. High Scores Menu </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209050896-5555d13c-642a-4a98-b252-e27a7c9024ea.png"/>
</p>
<p align="center">
  <b><i>Img 4. Settings Menu </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209046404-64821e21-dd54-4450-8002-5bcf2bb6a130.gif"/>
</p>
<p align="center">
  <b><i>GIF 1. Starting gameplay </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209049721-707f3f92-fac6-499d-b3ca-5ae272b957c0.gif"/>
</p>
<p align="center">
  <b><i>GIF 2. Boss fight Gameplay </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209239306-acb9e1db-2b59-4b99-ba53-16c456db448b.png"/>
</p>
<p align="center">
  <b><i>Img 5. Our Project's UML </i></b>
</p>
<br>
<br />

## Commands

| *Water Girl*                         | *Lava Boy*                     | *Menus*                      |
|--------------------------------------|--------------------------------|------------------------------|
| 	Move Right: <kbd>&rarr;</kbd>       | Move Right: <kbd>D</kbd>       | Move Up: <kbd>&uarr;</kbd>   |
| 	Move Left: <kbd>&larr;</kbd>        | Move Left: <kbd>A</kbd>        | Move Down: <kbd>&darr;</kbd> |
| 	Jump: <kbd>&uarr;</kbd>             | Jump: <kbd>W</kbd>             | Select: <kbd>ENTER</kbd>     |
| Shoot Water Power: <kbd>&darr;</kbd> | Shoot Lava Power: <kbd>E</kbd> | Pause:  <kbd>ESC</kbd>        |


## Design

### Class Organization

- **Problem in Context:** We sought a structural model for the organization of our classes to follow. This felt key in the initial stages of development since it allowed us to better coordinate ourselves, better plan the next steps, and more easily implement code by starting with a good foundation. The biggest issue was finding a way to segregate game data, its interfaces (such as the GUI we use) and game controls from each other, since we only started to apply the adequate pattern later on.

- **The Pattern:** The design pattern chosen was the **Model-View-Controller (MVC)**, an architectural pattern that divides the program into three parts. Since the game requires that we define its data structures, display the said data and allow the user to control it, we use MVC so that we can separate each of those concerns into into Model, View, and Controller, the said three parts.

- **Implementation:** The main folder contains three other folders that each represent the Model, the View and Controller.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/204053486-a47fb2f5-fe3c-47aa-a116-68b895d31e3b.png"/>
</p>
<p align="center">
  <b><i>Img 6. UML for the MVC design pattern implemented in our code  </i></b>
</p>
<br>
<br />

- **Consequences:** Testing and modifications are substantially easier due to element isolation, the project is cleaner and therefore easier to navigate since it reduces code agreggation and everything is more cohesive. 


### Varying Game States

- **Problem in Context:** As soon as we run the program, the game starts, and its execution will resume in a Game Over situation. In a fully functional game, the player should be firstly greeted with a menu that would allow them not only to decide when to press play but also to navigate through other options, such as instructions. In addition, the player should also encounter a Game Over menu when losing the game, which gives them the possibility of trying again. After winning the game, the player should be able to have the option of replaying it and seeing their completion time. This however, only felt possible by duplicating code and posed a threat to the maintenance of the Single Responsibility Principle since there would be classes with the many purposes of implementing each game state.

- **The Pattern:** In order to solve this problem, the design pattern to be applied is the **State Pattern**, a behavioral design pattern. It allows for the current game state to be kept in a mother State function in whose children functions the different states are specified, meaning the object can change its behavior when the internal state changes.

- **Implementation:**  Eight different functions represent the 8 different states present in our game: GameState, GameOverState, InstructionState, MenuState, PauseState, OptionsState, ScoreListState and GameWinState. The current game state is kept in an abstract	State function which all of the previous six functions extend.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209046590-7e3f8910-58db-4f5b-bd28-2a014aa48c91.png"/>
</p>
<p align="center">
  <b><i>Img 7. UML for the state esign pattern implemented in our code  </i></b>
</p>
<br>
<br />

- **Consequences:** Although this means that are more classes to manage, it makes it easier to track the behavior of each different state since they are divided. The several game state transitions become explicit, the **Single Responsibility Principle** is kept by avoiding obnoxious conditional structures, and it allows for new states to be added upon development without changing the context or existing state classes, which secures the **Open/Closed Principle**.

### Duplicated code in element creation

- **Problem in Context:** In our game, for almost every element concept there are two equal objects that concern each character. For instance, for the coin concept, we create Lava Coins and Water Coins. This resulted in a lot of duplicated code since each object behavior is not different, only generally differing in color and in which character they affect.

- **The Pattern:** To solve this issue we applied the **Factory Method** a creational design pattern. This way we were able to create several objects of superclass Element but each one of a different type. There are also subtypes for the separation of water and lava versions of an object.
 
- **Implementation:** We used this method in the controller and model. It was specially important in the controller because all of the different water and lava object variations present the same behaviour and so we created a common controller that each one extends. Since what sets them apart its their colors, in the viewer we did not implement this design pattern.

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209046759-13fcefe0-1948-4460-ae4d-ffb37a08fa24.png"/>
</p>
<p align="center">
  <b><i>Img 8. UML for the Factory Method design pattern implemented in our code  </i></b>
</p>
<br>
<br />

- **Consequences:** Allows separation of the methods that construct the object and the methods that use it. Just like MVC it also allows for a better organization of classes, which makes bug fixing and testing easier. Finally, it makes it easier to add new objet types further on.


## Known code smells and Refactoring 

### Large Class

The Arena class is very extensive and contains a lot of methods. However, we find it necessary since our game arena is made of several different elements, many of which exist in two variants: the water and the lava version. Nevertheless, although it still ended up being quite long, we did reduce it by scattering some methods through other classes, mainly by putting “lava methods” in “lava classes” and “water methods” in “water classes”.

### Large Method

There are many large step methods in controller, specially regarding the final boss. However, due to the range of different hehaviours that he may adopt we could not make it any shorter

### Lazy Class

There are some lazy classes such as the Instruction class. These however allow the code to be organized and in sync with the mvc structure


### Duplicated Code

Initially we had a lot of duplicated code, specially regarding the already described problem of frequently having two object variants of each element. Although the implementation of the Factory Method Pattern majorly solved this issue, there are still some repetitions, mainly concerning methods in the controller.

### Object Orientation Abuse

In the KeyHandler class we make use of several consecutive if statements. This however also feels necessary, not only because there are six movement keys, three for Water Girl and other three for Lava Boy, but also because two blocks of if statements are needed to enable both players to move at the same time.

### Dispensable Comments

Many comments may have been left behind which were notes left by each other for one another, reminders of things to change in the future or pieces of code to be worked on or that are dispensable for now.

## Testing

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209413080-a44d109e-b9b8-4b00-b869-be56df6f1803.png"/>
</p>
<p align="center">
  <b><i>Img 9. Intelij's test coverage report </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209413267-b94f4dca-ea15-46b6-9f69-d48e585dab96.png"/>
</p>
<p align="center">
  <b><i>Img 10. Jacoco Test coverage report </i></b>
</p>
<br>
<br />


<p align="center" justify="center">
  <img src="https://user-images.githubusercontent.com/92693155/209413016-42044364-b78f-447a-8cf2-0bea8ed407e7.png"/>
</p>
<p align="center">
  <b><i>Img 11. Pit Test coverage report </i></b>
</p>
<br>
<br />


## Self-Evaluation

- Manuel Silva: 50%
- Maria Laranjeira: 50%
