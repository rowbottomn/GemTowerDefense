# GemTowerDefense
A Java-based tower defense game.  Made with EB, BC and ES

## User Stories
0. As a player, I want to be able to place different types of towers on the map so that I can use different strategies and tactics to defend against enemy waves

- There are at least 3 different types of towers that can be placed (e.g. short range, long range, air)
- Towers can be placed anywhere on the map that is not obstructed
- Towers will automatically attack incoming enemies within their range
- Towers can also be used to mine

___

1. As a player, I want to see waves of enemies approaching along paths on the map so that I can plan my tower placements in advance of each attack

-  Enemies spawn in waves and move along clearly defined paths on the map
- Different enemy types have different speeds and health amounts
- The number and power of enemies increases with each new wave
  
___

3. As a player, I want to be able to upgrade my towers using gems so that I can strengthen my defenses and strategies over multiple waves of progressively harder enemies

- gems can be mined from rocks placed around the maps.
- gems have different colour types 
- Towers can be upgraded to increase their range, damage, attack speed though adding gems to the towers.  
- gems are upgradable and can be swaped in and out 
- gems have multiple levels and cost in-game resources like common and can be upgraded to uncommon, rare, lengendary and mythic.
- towers upgraded by gems have visible effects like increased range or damage numbers and other possble affects
  
___

4. As a player, I want to earn cash from defeating enemies to purchase new towers and upgrades so that I can customize and optimize my defenses over time

- Enemies drop cash when defeated, can be picked up by cursor/tap
- New towers and gem upgrades have a displayed cost that is deducted from the player's cash on purchase  
- Cash is accumulated between waves by player to afford more powerful towers  
  
___

5. ~~next sprint As a player, I want to see my performance rated after completing a wave so that I have a sense of progression and challenge level after each level~~ 

- Waves are clearly defined with a start and end
- After each wave, the player is given a rating (e.g. stars) based on enemy units defeated
- Losing all health from enemies reaching the end loses the game

___

6. As a player,
- I want a small and intuitive GUI for the tower buy menu
- Including options for three distinct towers: Fire Tower, Ice Tower, and Regular Tower.
___

## BackLog
    - basic tower fire at enemies.
    - basic tower can be placed on map using mouse.
    - spawners spawn basic enemies.
    - enemies have health bars that are removed when they run out of HP.
    - file is read to spawn in path and spawn rocks where the path is not.
    - rocks are destroyed and have a random chance to drop a common gem type.
    - gems can be placed onto towers to upgrade them in many possble ways (TBT).
    - implement a basic GUI on the right side of the players screen.
    - basic title screen for starting the game.
    - find art assets and sound assets for the game.
    - Enemy has a set speed, and health and follows a path 
    - Types of enemies: Goblins, ogors, slimes,gremlins and a dragon boss
    - Slimes are slow but low hp, ogors are slow and tanky
    - Goblins are fast but low hp and the Gremlins sprint when they get hit