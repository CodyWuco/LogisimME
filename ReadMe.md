# **VISION**
## To create a user-friendly Logic Simulator app, where the user can create basic logic circuits 
## and get immediate feedback. Easy to use and as simple as it could be yet professional at the
## same time. Perfect for beginners.

# **MISSION**
## To help users understand how logic circuits work. A simple app for beginners.

# **Team Members:**
      * Cody Wuco
      * Makenna Benson
      * Joshua Olson
      * Mehakdeep Singh


## Design
### Grid
* Will hold icons.
* grid will start out populated with empty grid cells and be populated by the user by using the Hud controls.
* Grid will be able to hold icons of different types that each trigger different events.
* Will hold the Hud temporarily until Hud layer created.
### Icons
* All logic icons should be same size fit on the grid.
* Will auto track themselves.
* Draw themselves at their locations.
### New Icons
* Click a logic icon on the Hud, then drag and drop the icon to the grid.
* When selecting new, an icon's original location will either display a greyed-out image of the icon or be empty.
* After selecting an icon by tapping, user can tap locations on the grid to place new icon.
* If using touch and drag, an icon will be placed on the grid after being released over the grid. Icon will be deselected and returned to hud. If icon isn't released over hud, will be deselected and returned without adding icon to the grid.
### Deselection
* Will be handled after each click to simplify design, but allow user to understand and control the actions of the grid.

### Delete Icons
* Click this icon to select it. Tap desired logic node to be deleted.
* can only delete user placed nodes.
* Deleting icon will delete all input wires connected to that icon.

### Connect Wires Icon
* Using a "connection mode", you can tap on an icon or a wire to create new wires to connect sources to inputs.

### Clear Screen
* Tap a clear screen icon to remove all user placed icons and wires from the grid
* Confirmation prompt (currently double tap).

### Stopping/Restarting Program
* The grids state will be automatically saved and reloaded.

### Back End:
### Selection Control
#### Logic Icon
* Click to select
* Set selected to logic icon
* Allowed to choose the type of cell dropped on empty cell location on nect click.
#### Delete
* Click to select.
* Set selected to delete.

#### Wire
* Wire Source:
click to select, then click logic node to select source.

#### Create Save

### Event Driven
#### All non-selection eventt rerturn selected to null. Prevents need for highlighting selected icon for easier interface

#### Logic Node
* On clicked
* If selected: Delete
	* Change grid cell to empty Cell.
	* Remove node input and output wires from System.
* If selected: Wire
	* Remove all wires attached to node.
* If selected: Logic node
	* Do nothing.
* Else if: Nothing selected
	* Defauly click action(toggle state).
* Turn logic nods into tree evaluator
	* Each node updates states on screen tap to prevent back track.
	* Node only acceps other nodes as input(prevent pointing to other grid objects).

#### Empty Cell
* If selected: Logic Icon
	* Set cell to logic node of icon
* Else
	* Do nothing

#### Reset grid Icon //not implemented
* Reset all caells to empty, delete all wires, and reset selected to null.

#### Saves
* If Selected, Create Save
	* Create save state of current grid.
* Else
	* Load selected grid save state.

