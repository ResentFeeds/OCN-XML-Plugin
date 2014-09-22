OCN-XML-Plugin
==============

This is a plugin that will let you make XML for you map in game following the OCN modules

Currently Supported Modules
===========================

So far you can generate an xml file with the following modules

- Name
- Version
- Objective
- Teams


Commands
========
-`/xml init` - start the xml creation process
-`/xml stop` - stops the xml creation process
-`/xml generate` - generates the xml file into your plugins folder (soon will upload to pastebin)
- `/xml name set <name>` - sets the name of the map
- `/xml name get` - returns the name of the map
- `/xml version set <version>` - sets the version of the map
- `/xml version get` - returns the version of the map
- `/xml objective set <objective>` - sets the objective of the map
- `/xml objective get` - returns the objective of the map
- `/xml teams add <name, color, max, max-overfill>` - adds a team to the XML (use `_` in the name for spaces)
- `/xml team edit <old_name, name, color, max, max-overfill` - edit an existing team
- `/xml teams get` - returns a list of all of the teams with each of their attribute values
