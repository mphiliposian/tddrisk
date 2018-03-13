# Definition of Done
- The program is "done" when it can determine a winner according to the rules and procedures of the game risk.
- A player is determined to be the winner when that player controls all 42 of the game's territories.
- A territory is defined as a cell which must contain at least one unit, and may only contain one player's units. The player whose units occupy a territory is said to control this territory.
- Territories are connected by routes. Routes are listed in appendix A.
- A unit is an abstract representation of a player's military force. Units are measured and represented as integers.
- A continent is a set of territories. Continents are listed in Appendix B.

## Setup
- There are 3 to 6 players. The program assigns each player a unique identifier. The territories under a player's control will be marked with this identifier. 
- At the start of the game, each player is provided with a number of units corresponding to the number of players in the game. These values are provided in appendix C. Units which a player owns but has not yet placed are referred to as "reinforcements".
- The program generates a turn ordering.
- Starting with the first player in the ordering, each player is prompted to select a territory on which to place a unit. This process repeats in the turn ordering until all territories contain exactly one unit. 
- Once all territories contain exactly one unit, each player is prompted to select a territory which they already control on which to place an additional unit from their reinforcements. This process continues in the turn ordering until each player has exhausted their supply of reinforcements. 
- The first player in the turn ordering is prompted to play a turn.
- After a turn is completed, the next player in the turn ordering who has not yet been eliminated is prompted to play a turn.
- A player is eliminated when they control no territories.

## Turns
- A turn is defined in three phases: Allocating reinforcements, attacking, and fortifying, and they always occur in this order.
### Allocating reinforcements:
- The active player is provided a number of reinforcements equal to 3, or the number of territories they control divided by 3, whichever is greater.
- The activate player is provided a number of reinforcements for each continent whose territories the player controls all of. The amount of reinforcements associated with each continent is shown in appendix B next to each continent's name.
- At any point during the allocating reinforcements phase, the player may choose to turn in 3 cards in order to obtain additional reinforcements. Cards are explained in appendix D.
- At any point during the allocating reinforcements phase, the player may add a reinforcement to any of their controller territories.
- The allocating reinorcements phase only ends when the player exhausts their reinforcements.
### Attacking:


## Appendix A: Routes

## Appendix B:
### North America (5)
- Alaska
- Alberta (Western Canada)
- Central America
- Eastern United States
- Greenland
- Northwest Territory
- Ontario (Central Canada)
- Quebec (Eastern Canada)
- Western United States

### South America (2)
- Argentina
- Brazil
- Peru
- Venezuela

### Europe (5)
- Great Britain (Great Britain & Ireland)
- Iceland
- Northern Europe
- Scandinavia
- Southern Europe
- Ukraine (Eastern Europe, Russia)
- Western Europe

### Africa (3)
- Congo (Central Africa)
- East Africa
- Egypt
- Madagascar
- North Africa
- South Africa

### Asia (7)
- Afghanistan
- China
- India (Hindustan)
- Irkutsk
- Japan
- Kamchatka
- Middle East
- Mongolia
- Siam (Southeast Asia)
- Siberia
- Ural
- Yakutsk

### Australia (2)
- Eastern Australia
- Indonesia
- New Guinea
- Western Australia


## Appendix C: Starting Units
Players    Units
----------------
3	35
4	30
5	25
6	20
