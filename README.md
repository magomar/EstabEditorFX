EstabEditorFX
=============

This project aims at providing an alternative Estab editor for the Command Ops Battles from the Bulge game series, from Panther Games.
The emphasis of this editor (compared with the original editor) is on the reuse and adaptation of existing data. 
The editor has been implemented as a desktop application using Java and JavaFX.
The main features of the editor are:
- Allows to load two estab files simultaneously: the **source** estab is opened in read mode; another estab, called the
 **target**,  is opened for edition.
- Elements in the source estab can be watched and copied into the target estab
- Elements in the target estab (the editable one) can be modified, created, duplicated and deleted
- Support multi-element actions (copying or deleting various elements in one operation) 
- When an element is copied, all its components (like the weapons of a vehicle) are copied
- Detects and avoids duplicates
- Forces can be created from scratch, specifying all its parameters and equipment, but also **by composition**. When a force is
specified as composed of other forces, some of its attributes (like personnel and staff capacity) are derived from the 
constituent forces, and the same happens with its equipment.

To download the binaries please visit the [project page](http://magomar.github.io/EstabEditorFX/).