# Definition of Done
- The program is "done" when it can determine a winner according to the rules and procedures of the game risk.
- A player is determined to be the winner when that player controls all 42 of the game's territories.
- A territory is defined as a cell which must contain at least one unit, and may only contain one player's units. The player whose units occupy a territory is said to control this territory.
- Territories are connected by routes. Routes are listed in appendix A.
- A unit is an abstract representation of a player's military force. Units are measured and represented as integers.

## Setup
- There are 3 to 6 players. The program assigns each player a unique identifier. The territories under a player's control will be marked with this identifier. 
- At the start of the game, each player is provided with a number of units corresponding to the number of players in the game. These values are provided in appendix B. Units which a player owns but has not yet placed are referred to as "reinforcements".
- The program generates a turn ordering.
- Starting with the first player in the ordering, each player is prompted to select a territory on which to place a unit. This process repeats in the turn ordering until all territories contain exactly one unit. 
- Once all territories contain exactly one unit, each player is prompted to select a territory which they already control on which to place an additional unit from their reinforcements. This process continues in the turn ordering until each player has exhausted their supply of reinforcements. 
- The first player in the turn ordering is prompted to play a turn.
- After a turn is completed, the next player in the ordering who has not yet been eliminated is prompted to play a turn.
- A player is eliminated when they control no territories.

## Turns
- 

## Appendix A: Routes

## Appendix B: Starting Units
Players    Units
----------------
3	35
4	30
5	25
6	20
