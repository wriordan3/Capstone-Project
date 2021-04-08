"# Capstone-Project" 
This program runs in command line with no arguments. Point of entry is "Main".

The game progresses through a series of questions with numbered inputs.
Enter only the number of the option would like to choose and press Enter to proceed.

The demo will terminate after the player has chosen option 4 in the Outpost.

Explanation of classes:
PlayerMap: Not fully necessary. Allows me to organize the necessary HashGraph functionality into an object that stores the Player's character traits.
Player: Stores all data related to the player with getters and setters. Contains internal class Alignment that represents the players current alignment based on the data in their playermaps.
Trait: Enumerated type designating the different alignment traits the player can have: Chaotic, Neutral, Lawful, and Evil, Neutral, Good
Skill: Abstract class containing the basic functionality for player and enemy combat skills.
PlayerSkill: Skills specific to the player required separate functionality.
HealingSkill: Skills that do something other than damage an enemy extend PlayerSkill and override the necessary methods. Unused data from the parent object is left at default values.
EnemySkill: Skills specific to enemies required separate functionality.
Room: Interface for all of the locations that the player will go. Contains static methods to manage communication between Main and the Room where the player is located.
RoomInit: Room to start the game. Gets the player's name and builds Player object.
Room1: Implementation of the first room of the story. Contains the first manipulation of the player's traits.
Room2: Second room. Demonstrates further manipulation of the player's traits. Also uses a state value that lets me make the room behave differently depending on the result of the last.
	   Also has the first use of HomeRoom, adding a mission to it's list of options and loading it as the next room.
HomeRoom: This Singleton Room is a hub area for the player, where they can upgrade their exosuit, purchase new weapons, and receive medical attention. 
	      It also stores all of the player's missions and handles timing of player level-ups.
	      The player can visit each of the options in the room as much as they like. Selecting one of their missions will continue the story.
Room3: Mission the player received in Room2 to find replacement parts for echo. Allows players to use their first augmented ability.
Room4: Was next room in the story before scrapping. Now placeholder that confirms the player has started the main story mission.
Room4a: Was first side mission before scrapping. Now placeholder that confirms the player has started a side mission.
Option: Unused
Weapon: Contains information about the player's current weapon, which is used for skills.
Armor:  Contains information about the player's current exosuit. This is used to calculate the Player's armor class;
Combat: This class is an object which can be constructed in rooms that have a combat sequence. It is constructed using a list of enemies and runs as a turn-based strategy loop.
		combat() handles the loop.
		As enemies die they are removed from the list. If the list is empty or the player dies, combat() returns a boolean true or false for player victory and defeat, respectively.
Main: This class handles initializing the game and contains a pointer to the Room where the player is located.
	  In the future, this will handle saving and loading a Player's location and the missions stored in their HomeRoom from a csv file.
