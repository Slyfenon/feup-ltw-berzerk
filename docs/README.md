## LDTS_l04gr02 - Berzerk

**Berzerk** é um jogo de ação e tiros. O objetivo do jogo passa por percorrer labirintos com paredes eletrificadas com vários inimigos robôs espalhados pelo mapa. O jogador tem a possibilidade de usar tiros para destruir os robôs e ganhar pontos enquanto se desvia dos inimigos e dos tiros que estes também disparam. O jogador também tem de se desviar das paredes eletrificadas para não perder pontos de vida. O jogo continua até que o jogador perca todas as vidas ou atinja a pontuação máxima. A dificuldade tende a aumentar à medida que o jogador avança de nível.


Projeto realizado por *Gonçalo Nunes* (*john.doe*@fe.up.pt), *Nuno Machado* (*jane.doe*@fe.up.pt) e *Vítor Pires* no âmbito da unidade curricular LDTS 2023⁄24.

### FUNCIONALIDADES IMPLEMENTADAS



### PLANNED FEATURES

### MOCKUPS

MainMenu
![](images/MainMenu.png)

PauseMenu
![](images/PauseMenu.png)

LeaderNorad
![](images/LeaderBoard.png)

GamePlay
![](images/gameplay.png)


### DESIGN

#### Architectural Pattern - MVC (Model-View-Controller)

![](images/mvc.png)

Decidimos usar este padrão de arquitetura de forma a mantermos as responsabilidades separadas e para que o desenvolvimento futuro de mais features se torne mais simplificado (maior facilidade na manutenção e reutilização de código, flexibilidade e extensibilidade, desenvolvimento paralelo e realização de testes).

- Model: É responsável por guardar toda a informação importante do jogo (sendo independente da interface do usuário e da representação visual). Guarda a informação do Maze, dos Menus e dos diferentes elementos do jogo.
- View: É responsável por mostrar toda a informação relevante que está guardada no Model, além disto também é responsável por receber os inputs do user e de os enviar para o Controller. A View é a única destas componentes que comunica com a GUI.
- Controller: É responsável por alterar a informação guardada no Model consoante os inputs do utilizador e aquilo que estiver a acontecer no jogo.

#### Singleton

Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso para essa instância.

- Problema: Sempre que o jogo inicia, é necessário criar uma instância da classe Game e não faz sentido que seja criada outra instância desta classe.
- Pattern: Usamos o padrão de Singleton para limitar a criação de mais instâncias de Game; a única instância é criada assim que o jogo começa a correr.

#### State

- Problema: Pretendemos que a classe Game se comporte de maneira diferente consoante o estado do jogo, isto é, o jogo tem funções muito diferentes se em vez de estar a correr o jogo em si, estiver no menu inicial ou nas instruções do jogo.
- Pattern: Decidimos usar o state pattern para resolver este problema visto que assim, através de um teste, conseguimos saber de que forma é que o jogo se deve comportar e poderemos encaminhá-lo para um estado que terá todas as funções necessárias ao seu bom funcionamento nesse momento.

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.


### SELF-EVALUATION

- Gonçalo Nunes 1/3 
- Nuno Machado: 1/3
- Vítor Pires: 1/3