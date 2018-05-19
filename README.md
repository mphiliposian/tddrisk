# Definition of Done
The program is "done" when it can determine a winner according to the rules and procedures of the game risk.
A player is determined to be the winner when that player controls all 42 of the game's territories.
A territory is defined as a cell which must contain at least one unit, and may only contain one player's units. The player whose units occupy a territory is said to control this territory.
Territories are connected by routes. Routes are listed in appendix A.
A unit is an abstract representation of a player's military force. Units are measured and represented as integers.
A continent is a set of territories. Continents are listed in Appendix B.

## Setup
- [x] There are 3 to 6 players. The program assigns each player a unique identifier. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/1d97918c38b85e5ab496571d85f4e0eddfea512c
- [x] At the start of the game, each player is provided with a number of units corresponding to the number of players in the game. These values are provided in appendix C. Units which a player owns but has not yet placed are referred to as "reinforcements". https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/d77c500113388a0dfb23064c40ab782df9465cfc
- [x] Starting with the first player in the ordering, each player is prompted to select a territory on which to place a unit. This process repeats in the turn ordering until all territories contain exactly one unit. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/1a5ec0802a060345537356145953bc1758469e1b
- [x] Once all territories contain exactly one unit, each player is prompted to select a territory which they already control on which to place an additional unit from their reinforcements. This process continues in the turn ordering until each player has exhausted their supply of reinforcements.  https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/e4556078105e584b681fba197e71f4b39075b01b


## Turns
- [x] A turn is defined in three phases: Allocating reinforcements, attacking, and fortifying, and they always occur in this order. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/cfcdd175071192057df928f61b8a73125a8d245f
- [x] After a turn is completed, the next player in the turn ordering who has not yet been eliminated is prompted to play a turn. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/cfcdd175071192057df928f61b8a73125a8d245f
- [x] A player is eliminated when they control no territories. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7ecd96e84812d9061ef86f5147a5f7fe0f18fb09


### Allocating reinforcements:
- [x] The active player is provided a number of reinforcements equal to 3, or the number of territories they control divided by 3, whichever is greater. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7ecdd5bbca50e14eae44ef156872a5b10ba84357
- [x] The activate player is provided a number of reinforcements for each continent whose territories the player controls all of. The amount of reinforcements associated with each continent is shown in appendix B next to each continent's name. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/30853d458a67e27e33e1bb72931ed0d873781f4d
- [x] At any point during the allocating reinforcements phase, the player may choose to redeem a set of cards, and this set must contain exactly 3 cards; either 1 from each group, or all 3 from the same group. Card details are explained in appendix D. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/5f21d64734e9399553d85575461a7f366b360d36
- [x] When a player redeems a set of cards, the following things happen: The cards are moved to a set of used cards, the player receives a number of reinforcements equal to a set value that the game keeps track of, a redeemed set counter is incremented, and the set value is increased. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/97b80528e221df39b3a14d734309db816fd99dc0 
- [x] The set counter starts at 0, and the set value starts at 4. For each additional set redeemed, the set value increases by 2. When the set counter reaches 7, the set value increases by 5, and all future sets redeemed also increase the set value by 5. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/4b5ab4807ac0cd6ada9f4f9e333999750ec8c88c
- [x] If a player redeems a set of cards which contains a card that is associated with at least one of the territories that they control, the player is prompted to select one of these territories, and 2 additional reinforcements are placed on the territory they select. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/merge_requests/17/diffs?commit_id=0322e48601e2984a7b6e45fd22cb61c1878c877f
- [x] At any point during the allocating reinforcements phase, the player may add a reinforcement to any of their controller territories. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7704233d5c62c0e8b9a11b8d509f903c5c50a3d4
- [x] The allocating reinorcements phase only ends when the player has 0 reinforcements. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7704233d5c62c0e8b9a11b8d509f903c5c50a3d4

### Attacking:
- [x] Players can choose to attack or continue to the fortifying phase. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7524b8082ca45a7d4f9b6f7341a779d322e2c46c
- [x] Players can only attack territores that are adjacent or connected to territories that the attacknig player owns. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/f037677dd24b9bb776abdbc37442dfdb5a38d300
- [x] A territory must have atleast two units to declare an attack on another territory https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/b752c3e7fc795bc45b54f6ad8ee9be4906bd6630
- [x] The attacking player may continue to attack one country until he has elimated the enemy units on the territory or until he has only one unit left. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/2870be892314925c807ac797feecd79ea9a849fb
- [x] The attacking player may also choose to attack a new territory as much as they'd like durring there attacking phase. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/59c94a8ad055903d8c3a8d2c8755cd7bea8d2f62


#### Deciding the Winner of a battle
- [x] A winner is declared by the higher dice roll. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/72cb4ab6dad6da6a7c08fe300547d45e51400829
- [x] If the attacker has a higher dice roll, then the defender loses one unit. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/72cb4ab6dad6da6a7c08fe300547d45e51400829
- [x] If the defender has a higher dice roll, then the attacker loses one unit. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/fa48ae511135f56f4469f79f60d02a814f376e54
- [x] If the defender and the attacker tie for the highest roll, then the attacker loses one unit. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/fa48ae511135f56f4469f79f60d02a814f376e54
- [x] If each player rolled more than one dice, then compare the two next highest dice and repeat the above win conditions. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/28cacd8204592dd8adbfdffdc627e8a6f9fa0d86

#### Capturing a territory
- [x] After defeating all units on a territory, the attacking player must occupy the territory imediately by moving units that attacked onto that territory. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/2870be892314925c807ac797feecd79ea9a849fb
- [x] The Player can move as many or as little units as they'd like onto that territory as long as the territory you attacked from has one unit left on it. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/2870be892314925c807ac797feecd79ea9a849fb

#### Eliminating an opponent
- [x] If durring the players turn, they eliminate an opponent (reduce the enemy players units to 0), the winning player recieves the defeated enemies RISK cards. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/ecd369a582be5019ea7d42ed3eafb6305696d727
- [x] If the player holds 6 or more RISK cards in there hand, then they must imediately turn in a set and place the recieved units on any of their owned territores. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7f71faf7d0749187b32aa9e5752741172a7812f1
- [x] If the player has less than 5 cards after recieving them from the enemy, then they must wait until their next turn to turn in a set. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7f71faf7d0749187b32aa9e5752741172a7812f1

#### Ending an attack
- [x] The player end their attacks at anytime durring the attack phase. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/7524b8082ca45a7d4f9b6f7341a779d322e2c46c
- [x] If the player captured atleast one territory, then the place recieves a RISK card. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/4dcf4705dd086373d8fe11c435d8866df6e974f2
- [x] The player then continues to the Fortify phase https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/cfcdd175071192057df928f61b8a73125a8d245f

### Fortifying
- [x] Players can move units from one territory to another territory as long as a set of adjacent or connected paths connect them. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/69c63746791d244ac561b60feef2fe4236b72368
- [x] The Player must also leave atleast one unit behind when moving units to a new territory. https://ada.csse.rose-hulman.edu/csse376-s1-g/risk/commit/91460dce706fb21299f47dc4dd2eb44c91ce28e6

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
|         |       |
| 3	      | 35    |
| 4	      | 30    |
| 5	      | 25    |
| 6	      | 20    |

## Appendix D: Cards
There are 42 unique risk cards, each associated with specific territory.
These cards are evenly divided into three groups,  and each group is marked with a unique identifier.
There are 2 additional cards which are not associated with a territory, but belong to all three of the card groups.