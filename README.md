#Jets Project

####Title: Fleet Fly In

##Week Three Skill Distillery Homework

### Overview
The Fleet Fly In (or Jets project) loads a list of aircraft and allows the user to pick different options based on the type of aircraft.  Type being fighter jet, cargo plane, trainer plane, or "other" which covers all other types of aircraft.  Below is a description of each menu item.

1. **List Fleet**:
This will list all current aircraft in the jet list (`List<Jet> jetList`).  It will list the aircraft model, speed (mph), range (mi), and the cost.  Note, the speed of all default planes is the cruise speed.  When the java program starts, it will populate the list from "jets.txt" containing six different aircraft.  Other menu options will allow the user to manipulate this list by adding or deleting files.

2. **Fly all aircraft**:
This will list the maximum time each aircraft can fly.  It was created by dividing the cruise speed by the range.

3. **Fly single aircraft**:
This option mimics "Fly all aircraft," but it allows a user to choose a single aircraft to fly.

4. **View fastest aircraft**:
The fastest aircraft based off mph will appear with all its information listed.

5. **View aircraft with longest range**:
Similar to option four, this will list the aircraft with the longest range.

6. **Load all cargo aircraft**:
When the program runs or the user enters a new plane, a value of FighterJet, CargoPlane, Trainer, or Other is given.  This is information is used to assign the plane to a child of the abstract "Jet" class.  However, each child also has an interface with specific methods for that type of aircraft.  In this case, the cargo aircraft will call the method `public void loadCargo()` that is implemented from the CargoCarrier interface.  When called, the cargo planes will be loaded with the message "cargo loaded!"

7. **Dogfight!**:
Dogfight uses interface as described above but for the FighterJet type and calls `public void fight().` One of two messages located in an array could pop up when called.  The array allows for expansion on what could be listed, but as the program stands, it only contains two strings.

8. **Train**:
Train is an interface for the Trainer type of plane.  This will show the user a menu with six different training options and a quit option.  A while loop was used, so in order to end training the quit option must be chosen.  Each training type will give random feedback on whether a maneuver was good, ok, or bad.

9. **Add aircraft to fleet**:  
First, the user will pick what type of aircraft they would like to add.  This allows menu option 6, 7, or 8 to be used with the aircraft.  When run, the program uses `jetList.add(new Type(model, ...price));` to add the new plane to the fleet.  

10. **Remove aircraft from fleet**:
The user may also remove an aircraft from the fleet.  Have a gripe with the F-35? More of a Cessna fanboy than a Cirrus person?  Don't stress over it -- just remove them!  This is accomplished by using `jetList.remove(index)`.

When option 9 and 10 are used, the `jetList` will be updated and this will be reflected when using all other menu items.

10. **Quit**:
There is only so much cargo loading and training one can do in a day.  This will let the user quit.  It wasn't all for nothing; all that data entry (or deletion) can be saved!  The user can either type Y to save or N-ything else to not save.  This goes to a file called "myJetList.txt"

**Exceptions added:**
1.  When there are no planes in the jetList, a message will tell the user they can add more planes through the "Add a aircraft to fleet" option.
2.  Similarly, if there are no Cargo, Fighter, or Trainer type planes in the jet list, a respective message will pop up if trying to use the Load all cargo, Dogfight, or Train options.
3.  Some, but not all, menus have `try` and `catch` to prevent the program from breaking when an integer is expected but the user types in a string.

### Technologies/ Topics Applied
- **ArrayList**:
An Array list containing the object Jet (`List<Jet>`) is what the program retrieved data from.

- **Exceptions**:
`try` and `catch` was used in order to prevent IOException or FileNotFoundException when using FileReader/Writer.  It was also used on a few menus to prevent the program from breaking when a string was entered instead of an integer.

- **Input/ Output Streams**:
jetList originally gets its data from `jets.txt`.  In order to import, FileReader is needed to read the file, then BufferedReader is needed to read lines of the txt file using `.readLine()`.  Later, FileWritter is used with PrintWritter in order to create a new file `myJetList.txt` in order to save data.

- **Superclasses**:
The Jet class was a superclass that all plane types relied on.

- **Abstract Classes**:
The jet class was an abstract class that all subclasses inherited methods from.  Each subclass had a model, speed, range, and price.  The jet class was used to define these.

- **Interfaces**:
CargoPlane, FighterJet, and Trainer classes implement the CombatReady, CargoCarrier, and Train interfaces, respectively.  This allows the classes to remain subclasses of Jet but use the abstract methods from the interfaces.

- **Abstract Methods**:
Interfaces use abstract methods that do not have a body.  Instead the concrete subclasses override them.

- **Overriding**:
The CargoPlane, FighterJet, and Trainer classes override the abstract methods from their interfaces.


### Lessons Learned
The trickiest part of this project was figuring out how to get data from a .txt file into a list.  The biggest learning point was that a list can contain user defined objects.  Any previous programming I had done used already defined objects or primitive types such as String, int, etc.  I was trying to put the data in list containing a string array (or `List<String[]>`).  This did not work when trying to cast the aircraft to a certain type. Eventually I figured out I needed to make a list containing the Jet object.

The next obstacle I ran into was figuring out how to call the correct type of plane out of jetList.  Eventually, I learned all I needed to do was call instanceof such as `jetList.get(i) instanceof CargoPlane`.

Jet Project gave a better understanding of abstract classes and interface.  The abstract class was not called in any other methods.  It was only used in its subclasses though `extends Jet`.  This gave a greater understanding of how subclasses use abstract classes.  Interface was something I did not understand going into the project.  Now I know interfaces are used to give additional properties that may be unique to a subclass (or subclasses) but not appropriate for an abstract class.
