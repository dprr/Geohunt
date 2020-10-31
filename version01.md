# VERSION 0.1

## Game goals
1. Create a game localy
1. Play a game localy

## Overview
### Create a game
1. Pick game name <name>
1. Walk to waypoint <i>
1. Mark location as waypoint <i>
1. if <done> goto 6
1. goto 2
1. Save game under name <name>
1. return to main screen

### Play a game
1. Pick game name <name>
1. See waypoint <i>
1. Walk to waypoint <i>
1. Mark waypoint <i> as found
1. if location is within RANGE mark as found
1. else send error message
1. if all waypoints are marked finish game
1. else goto 4

## Future features
1. Mark waypoint with a map
1. Store game on server

## Screens In Game

### Welcome screen
* Create Game
	* GOTO create game page
* Join Game
	* GOTO join game page

### Create Game
* Textbox to name game
* Button to add location
	* GOTO create Location
* Button to finish

### Create Location
* Textbox to describe location
* Button to mark location as current location
* Button to finish

### Join game page:
* List of all game names
	* GOTO play game page

### Play game page
1. Display current location
1. Button to claim that phone is in location
	1. if phone is in location, announce and set next location as current location
1. if current location is empty announce game win and goto Welcome screen
1. GOTO 1

