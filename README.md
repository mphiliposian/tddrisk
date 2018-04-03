# Definition of Done
- [ ] The program is "done" when it can determine a winner according to the rules and procedures of the game risk.
- [ ] A player is determined to be the winner when that player controls all 42 of the game's territories.
- [ ] A territory is defined as a cell which must contain at least one unit, and may only contain one player's units. The player whose units occupy a territory is said to control this territory.
- [ ] Territories are connected by routes. Routes are listed in appendix A.
- [ ] A unit is an abstract representation of a player's military force. Units are measured and represented as integers.
- [ ] A continent is a set of territories. Continents are listed in Appendix B.

## Setup
- [x] There are 3 to 6 players. The program assigns each player a unique identifier. 
- [x] The territories under a player's control will be marked with this identifier. 
- [x] At the start of the game, each player is provided with a number of units corresponding to the number of players in the game. These values are provided in appendix C. Units which a player owns but has not yet placed are referred to as "reinforcements".
- [x] The program generates a turn ordering.
- [x] Starting with the first player in the ordering, each player is prompted to select a territory on which to place a unit. This process repeats in the turn ordering until all territories contain exactly one unit. 
- [x] Once all territories contain exactly one unit, each player is prompted to select a territory which they already control on which to place an additional unit from their reinforcements. This process continues in the turn ordering until each player has exhausted their supply of reinforcements. 


## Turns
- [ ] A turn is defined in three phases: Allocating reinforcements, attacking, and fortifying, and they always occur in this order.
- [ ] The first player in the turn ordering is prompted to play a turn.
- [ ] After a turn is completed, the next player in the turn ordering who has not yet been eliminated is prompted to play a turn.
- [ ] A player is eliminated when they control no territories.


### Allocating reinforcements:
- [ ] The active player is provided a number of reinforcements equal to 3, or the number of territories they control divided by 3, whichever is greater.
- [ ] The activate player is provided a number of reinforcements for each continent whose territories the player controls all of. The amount of reinforcements associated with each continent is shown in appendix B next to each continent's name.
- [ ] At any point during the allocating reinforcements phase, the player may choose to redeem a set of cards, and this set must contain exactly 3 cards; either 1 from each group, or all 3 from the same group. Card details are explained in appendix D.
- [ ] When a player redeems a set of cards, the following things happen: The cards are moved to a set of used cards, the player receives a number of reinforcements equal to a set value that the game keeps track of, a redeemed set counter is incremented, and the set value is increased. 
- [ ] The set counter starts at 0, and the set value starts at 4. For each additional set redeemed, the set value increases by 2. When the set counter reaches 7, the set value increases by 5, and all future sets redeemed also increase the set value by 5.
- [ ] If a player redeems a set of cards which contains a card that is associated with at least one of the territories that they control, the player is prompted to select one of these territories, and 2 additional reinforcements are placed on the territory they select.
- [ ] At any point during the allocating reinforcements phase, the player may add a reinforcement to any of their controller territories.
- [ ] The allocating reinorcements phase only ends when the player has 0 reinforcements.

### Attacking:
- [ ] Players can choose to attack or continue to the fortifying phase.
- [ ] Players can only attack territores that are adjacent or connected to territories that the attacknig player owns.
- [ ] A territory must have atleast two units to declare an attack on another territory
- [ ] The attacking player maybe continue to attack one country until he has elimated the enemy units on the territory or until he has only one unit left.
- [ ] The attacknig player may also choose to attack a new territory as much as they'd like durring there attacking phase.

#### To Attack
- [ ] After the attacker selects which territory they are attacking, they and the enemy must select how many "dice" they intend to roll.
- [ ] The attacker may choose to roll 1,2, or 3 "dice". They must have 1 more unit than the dice they roll.
- [ ] The attacker may choose to roll 1, or 2 "dice". They must have 1 more unit than the dice they roll.

#### Deciding the Winner of a battle
- [ ] A winner is declared by the higher dice roll.
- [ ] If the attacker has a higher dice roll, then the defender loses one unit.
- [ ] If the defender has a higher dice roll, then the attacker loses one unit.
- [ ] If the defender and the attacker tie for the highest roll, then the attacker loses one unit.
- [ ] If each player rolled more than one dice, then compare the two next- [ ]highest dice and repeat the above win conditions.

#### Capturing a territory
- [ ] After defeating all units on a territory, the attacking player must occupy the territory imediately by moving units that attacked onto that territory.
- [ ] The Player can move as many or as little units as they'd like onto that territory as long as the territory you attacked from has one unit left on it.

#### Eliminating an opponent
- [ ] If durring the players turn, they eliminate an opponent (reduce the enemy players units to 0), the winning player recieves the defeated enemies RISK cards.
- [ ] If the player holds 6 or more RISK cards in there hand, then they must imediately turn in a set and place the recieved units on any of their owned territores.
- [ ] If the player has less than 5 cards after recieving them from the enemy, then they must wait until their next turn to turn in a set.

#### Ending an attack
- [ ] The player end their attacks at anytime durring the attack phase.
- [ ] If the player captured atleast one territory, then the place recieves a RISK card.
- [ ] The player then continues to the Fortify phase

### Fortifying
- [ ] Players can move units from one territory to anotherr territory as long as a set of adjacent or connected paths connect them.
- [ ] The Player must also leave atleast one unit behind when moving units to a new territory.

## Continuing the game
After the fortifying phase, a player ends their turn and then the next player takes their turn.

## Winning
Turns continue until one player elimates all opponents by capturing all 42 territories.

## Appendix A: Routes

## Appendix B:
### North America (5)
- [ ] Alaska
- [ ] Alberta (Western Canada)
- [ ] Central America
- [ ] Eastern United States
- [ ] Greenland
- [ ] Northwest Territory
- [ ] Ontario (Central Canada)
- [ ] Quebec (Eastern Canada)
- [ ] Western United States

### South America (2)
- [ ] Argentina
- [ ] Brazil
- [ ] Peru
- [ ] Venezuela

### Europe (5)
- [ ] Great Britain (Great Britain & Ireland)
- [ ] Iceland
- [ ] Northern Europe
- [ ] Scandinavia
- [ ] Southern Europe
- [ ] Ukraine (Eastern Europe, Russia)
- [ ] Western Europe

### Africa (3)
- [ ] Congo (Central Africa)
- [ ] East Africa
- [ ] Egypt
- [ ] Madagascar
- [ ] North Africa
- [ ] South Africa

### Asia (7)
- [ ] Afghanistan
- [ ] China
- [ ] India (Hindustan)
- [ ] Irkutsk
- [ ] Japan
- [ ] Kamchatka
- [ ] Middle East
- [ ] Mongolia
- [ ] Siam (Southeast Asia)
- [ ] Siberia
- [ ] Ural
- [ ] Yakutsk

### Australia (2)
- [ ] Eastern Australia
- [ ] Indonesia
- [ ] New Guinea
- [ ] Western Australia


## Appendix C: Starting Units
| Players | Units |
|     |       |
| 3	  | 35    |
| 4	  | 30    |
| 5	  | 25    |
| 6	  | 20    |

## Appendix D: Cards
- [ ] There are 42 unique risk cards, each associated with specific territory.
- [ ] These cards are evenly divided into three groups,  and each group is marked with a unique identifier.
- [ ] There are 2 additional cards which are not associated with a territory, but belong to all three of the card groups.