# **TEAM NAME**
### MythicEncrytion
# **VISION**
To create a user-friendly Logic Simulator app, where the user can create basic logic circuits and get immediate feedback. Easy to use and as simple as it could be yet professional at the same time. Perfect for beginners.


## Design:

Grid

-   Will hold icons
    
-   The grid will start out populated with empty grid cells and be populated by the user by using the Hud controls.
    
-   The grid will be able to hold icons of different types that each trigger different events.
    
-   Will hold the Hud temporarily until I can understand Android Studio well enough to create a Hud layer
    

Icons

-   All Logic icons should be the same size to fit on the grid.
    
-   They will keep track of themselves.
    
-   They will draw themselves at their locations.
    

New icon

-   Click a Logic icon on the Hud. Then drag and drop the icon to the grid
    
-   When selecting new an icon the icon’s original location will either display a greyed-out image of the icon or be empty.
    
-   After selecting an icon by tapping the user can tap locations on the grid to place a new icon.
    
-   If using touch and drag an icon with be places on the grid after being release over the grid, and then the icon will be deselected and returned to the Hud. If the icon isn’t release over the Hud, it will be deselected and returned without adding an icon to the grid
    

Deselection

-   Will be handled after each click to simplify design, but still allow user to understand and control the actions of the Grid.
    

Deletes icon

-   Click this icon to select it. Then tap the Logic node you want deleted.
    
-   This can only delete user places nodes.
    
-   Deleting an icon will delete all input wires connected to that icon.
    

Connect Wires icons

-   Using a “Connection Mode” you can tap on an icon or a wire to create new wires to connect Sources to inputs.
    

-   This will be done with a choose Source and choose Input icon until they can be combined to produce and intuitive 1 button solution.
    

Cut Wire Icon

-   Turns on wire cutting mode
    

-   When user clicks on a node it will remove that nodes connections to its sources.
    

Clear Screen

-   Tap a Clear Screen icon to remove all user placed icons and wires from the grid.
    
-   Confirmation prompt.
    

-   Currently tapping twice
    

Stopping/Restarting program

-   The grids state will be automatically saved and reloaded.
    

  
  

## Back end:

Selection Control:

-   Logic icon
	-   Click to select
	-   Set selected to logic Icon
	-   Allowed to choose the type of cell dropped on empty cell location on next click.
    

-   Delete
	-   Click to select
	-   Set selected to delete
    

-   Wire
	-   WireSource
		-   Click to select
		-   Then click Logic node to select Source
	   -   WireInput
		    -   Click to select
		   -   Then click the logic node you want to have the Source
		-   CutWire
			-   Click to select
			-   The click logic node to remove all inputs
    

-   Create Save
Event Driven:

All non-selection event return selected to null. Prevents the need for highlighting the selected icon, so that the user knows what to expect:

-   Logic node
	-   On clicked
	-   If selected delete
	    -   Change grid cell to empty Cell
		   -   Remove node input and output wires from system
    -   If selected wire
	    -   If input wire state
		    -   If input empty
			    -   Set input to output of the node wire has selected
	    -   If output wire state
		    -   Set wire output node to clicked node
    -   If selected is wire delete
	    -   Remove all wires attached to node
    -   If selected Logic node
		   -   Do nothing
    -   Else If nothing is selected
	    -   Do default click action
		    -   Usually toggle state
    -   Turn logic nods into I tree evaluator
	    -   Each node updates State on screen tap to prevent need for keeping track of a tree.
	    -   Nodes only accept other nodes as an input. That way no one can point to other grid objects.

   -   Empty Cell
	    -   If selected Logic Icon
		    -   Set cell to Logic node of icon
	    -   Else
		    -   Do nothing
	-   Reset grid Icon //not implemented
		-   Reset all cells to empty, delete all wires, and reset selected to null.
-   Saves
    -   If selected create save
	    -   Create a save state of the current grid
    -   Else
	    -   Load the selected grid save state.
    
 ## Screen objects:
 #### Grid:
-   A basic graph like grid
   -   Snap to grid would allow for greater control and predictability.
-   Grid is composed of Cells
    

#### Size:
-   ~10 gates should fit comfortable (Recommended approach)
-   Sets icon sizes 
-   Should be only 1 screen in size
    

#### Cells:
-   Each cell keeps track of its position on the grid
-   Each cell draws itself
    

### Hud:

#### Controls Icons(Cells):

-   Clear Screen Icon
    -   Delete all logic nodes and reset grid
    -   Need to click 2 time to activate
-   Delete Icon
    -   Click to choose Delete Mode
-   Wire Icons
    -   Click for Wire Mode
-   Create Save Icon
    -   Click for Create Save Mode
-   Saves Icon
    -   Clicked to create and load saves
-   Logic Selection Icons:
    -   Drops a logic cell when clicking an empty grid cell after selecting this
    

#### Wire Icons:
-   Wire Source
    -   Selects the source for the connection
-   Wire Input
    -   Selects the input for the connection
-   Cut Wire
    -   Removes the input connections from a node.

#### Logic Icons:
-   Each node draws its own wire
    -   Each node keeps track of its source
    
-   Each node Evaluates its own state
    -   Click one to select place logic mode
    

#### Logic Gate Icons:

-   AND gate icon
    -   In this mode clicking an empty cell will replace it with an And Gate
    

-   OR gate icon
    -   In this mode clicking an empty cell will replace it with an Or Gate
    

-   NOT gate icon
    -   In this mode clicking an empty cell will replace it with an Not Gate
    

-   Switch icon
    -   In this mode clicking an empty cell will replace it with an Switch Gate
    

-   Light icon
    -   In this mode clicking an empty cell will replace it with an Light Gate
    

#### Logic Cells (Cells):

Gates:

Not gate
- Invert input into opposite input.
 -   1 input 1 output
    

AND gate
-   Only outputs out an “on” signal if both inputs are “on”.
 -   2 inputs 1 output
    

OR gate
-   Outputs out an “on” signal if either input is “on”.   
-   2 inputs 1 output.
    

#### Inputs/Outputs:

On/off switch
-   Tap to switch output to “on” or “off”’. 
-   Outputs constant signal depending on state.
-   Should have an obvious visual difference between states.
    

Lights
-   Turns on (glows) when receiving an “on” input
    

#### Connectors:

Wires
-   Connects sources to inputs

## New Features:

#### Nested Circuit

-   LED base tree circuit (Circuit should save from the LED, and read down similarly to Eval() function.
-   Save switches or Null inputs as input for new circuit, and LEDs as output
-   Naming sace for easy lookup
-   preset schematic (being able to design and save schematics to use in future designs).
    

#### Better Grid and Buttons:

-   Grid needs to be unchanging when the phone’s orientation changes and should be larger than the screen (at least squared off)

-   We need buttons on a U.I. layer, so we can still press buttons when the grid view is moved around.
    -   Currently buttons are hard coded on the grid, and you are unable to see or press them if you move the grid view around.
   
-   Toggle move grid view
    -   Currently the grid registers touches on the screen as trying to touch a grid cell.
    -   We need to create a way to touch the screen to drag the grid view around.
	    -   This can be done with arrow buttons on the U.I. layer or a toggle button for drag and drop grid view modes.
    
-   User feedback for screen touches
    -   beeps/vibrations (different type/sounds)
	    -   pressing a button
	    -   Overlapping objects
	    -   Outputs
    

#### Better Wire:

-   Glowing wires that display what signal a gate is outputting
-   Fix wire draw to be more user friendly    
-   Delete wire when source is deleted
-   Maybe wiring revamp


# **Team Members:**
  * Cody Wuco
  * Makenna Benson
  * Joshua Olson
  * Mehakdeep Singh