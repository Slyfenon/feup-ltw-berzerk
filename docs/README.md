# LDTS_l04gr02 - Berzerk

> **Berzerk** is an action and shooting game. The game's objective revolves around navigating mazes with electrified walls while encountering various enemy robots scattered throughout the map. The player has the ability to use shots to destroy the robots and earn points while dodging both enemies and the shots they fire. Additionally, the player must evade electrified walls to prevent losing life points. The game continues until the player loses all lives or reaches the maximum score. The difficulty tends to increase as the player advances levels.

This project was developed by *Gonçalo Nunes* (up202205538@up.pt), *Nuno Machado* (up202206186@up.pt) e *Vítor Pires* (up202207301@up.pt) for LDTS 2023⁄24.

## IMPLEMENTED FEATURES

- **Graphics and Interface**: graphical implementation of various game elements (including visual representations for the maze, characters, shots, scores, and other elements); StickMan and Robot Images react to their movement;
- **Main Menu**: allows starting the game, checking a leaderboard with top scores, accessing game instructions, or exiting the application;
- **Leaderboard**: displays top scores achieved by players;
- **Game Instructions**: provides clear guidance on game rules and controls for players' understanding;
- **Maze**: reading maze configurations from text files;
- **Stickman**: Player controls a stickman that must survive by eliminating enemies and avoiding being hit by them, their shots, or the obstacles present in the scenario.
- **StickMan Movement**: through player inputs;
- **Enemies**: robots chase the StickMan (some shoot in the player's direction), EvilSmile is a indestructible enemy that pursues the player, increasing difficulty and encouraging constant movement.
- **Shots and Collisions**: development of shooting and collision mechanics for the main character and enemies. Being hit by shots or colliding with enemies results in the loss of a life.
- **Scoring**: scoring system rewards the player for destroying enemies (max. score = 9950);
- **Lives**: the player begins the game with 3 lives and can have a max. of 5 lives, the player earns an extra life for every 500 points scored during gameplay;
- **Game Over Screen**: the game continues until the player loses all their lives. When this happens, the game ends, and the player has the option to record the achieved score (which will be saved only if it qualifies to enter the leaderboard);
- **Sound Effects**: 

## MOCKUPS

MainMenu

![](images/MainMenu.png)

PauseMenu

![](images/PauseMenu.png)

Leaderboard

![](images/LeaderBoard.png)

GamePlay

![](images/gameplay.png)


## IMPLEMENTATION

### UML

![](images/uml.png)

## DESIGN PATTERNS

### Architectural Pattern - MVC (Model-View-Controller)

#### Problem in context:
- Managing data (Model), user interface (View), and user interactions (Controller) in a single structure could lead to tangled code and maintenance challenges.

#### The pattern:
- MVC separates an application into three main components: Model, View, and Controller.

#### Implementation:

- The packages - Model, View and Controller - can be found, respectively, in:


#### Consequences:
- Easier maintenance, and updates. Enhances code reusability and scalability.

- MVC separates an application into three main components: Model, View, and Controller.
![](images/mvc.png)

Decidimos usar este padrão de arquitetura de forma a mantermos as responsabilidades separadas e para que o desenvolvimento futuro de mais features se torne mais simplificado (maior facilidade na manutenção e reutilização de código, flexibilidade e extensibilidade, desenvolvimento paralelo e realização de testes).

- Model: É responsável por guardar toda a informação importante do jogo (sendo independente da interface do usuário e da representação visual). Guarda a informação do Maze, dos Menus e dos diferentes elementos do jogo.
- View: É responsável por mostrar toda a informação relevante que está guardada no Model, além disto também é responsável por receber os inputs do user e de os enviar para o Controller. A View é a única destas componentes que comunica com a GUI.
- Controller: É responsável por alterar a informação guardada no Model consoante os inputs do utilizador e aquilo que estiver a acontecer no jogo.

=======
A implementação concreta pode ser encontrada aqui:
- [Model](https://github.com/FEUP-LDTS-2023/project-l04gr02/tree/main/src/main/java/com/ld04gr02/berzerk/model)
- [Controller](https://github.com/FEUP-LDTS-2023/project-l04gr02/tree/main/src/main/java/com/ld04gr02/berzerk/controller)
- [View](https://github.com/FEUP-LDTS-2023/project-l04gr02/tree/9e535c984c979dfa7cf10b7be44f49e298b246de/src/main/java/com/ld04gr02/berzerk/view)

#### Implementation:

#### Consequences:

- **Pros**: guarantees a single instance throughout the application, offering a global access point for that instance; allows a more efficient management of resources, avoiding redundant object creation; 
- **Cons**: it is more difficult to test code;

### Singleton

#### Problem in context:
- **Problem**: Excessive object creation leading to resource depletion or conflicts.
- **Context**: We chose to implement the Singleton pattern due to 'javax.sound.sampled.LineUnavailableException' error, which occurred because multiple instances of sound-related objects were being created concurrently.

#### The pattern:
- Singleton restricts a class to have only one instance and offers global access to that instance.

#### State


#### Problem in context:


- Problema: Pretendemos que a classe Game se comporte de maneira diferente consoante o estado do jogo, isto é, permitir ao jogo ter funções muito diferentes consoante o seu estado aliando isso a uma troca entre estados bastante rápida.
- Pattern: Decidimos usar o state pattern para resolver este problema visto que assim, através de um teste, conseguimos saber de que forma é que o jogo se deve comportar e poderemos encaminhá-lo para um estado que terá todas as funções necessárias ao seu bom funcionamento nesse momento.
  

![](images/stateDiagram.png)
State Diagram

- Consequências: Possibilita a implementação de um novo estado de uma forma bastante mais fácil, sem ter de alterar qualquer dos estados já existentes.

#### The pattern:
- Singleton restricts a class to have only one instance and offers global access to that instance.

#### Implementation:

#### Consequences:

- **Pros**: guarantees a single instance throughout the application, offering a global access point for that instance; allows a more efficient management of resources, avoiding redundant object creation;
- **Cons**: it is more difficult to test code;
- 
- Problema: Pretendemos que a classe Game se comporte de maneira diferente consoante o estado do jogo, isto é, o jogo tem funções muito diferentes se em vez de estar a correr o jogo em si, estiver no menu inicial ou nas instruções do jogo.
- Pattern: Decidimos usar o state pattern para resolver este problema visto que assim, através de um teste, conseguimos saber de que forma é que o jogo se deve comportar e poderemos encaminhá-lo para um estado que terá todas as funções necessárias ao seu bom funcionamento nesse momento.

### ERROR-PRONE WARNINGS
- No error-prone warnings.

### CODE SMELLS

- 

### TEST COVERAGE




### MUTATION TESTING (PITEST)




### SELF-EVALUATION

- Gonçalo Nunes 33,3%
- Nuno Machado: 33,3%
- Vítor Pires: 33,3%