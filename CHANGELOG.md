#v1.3.0

- New tool to list all the elements of a estab. Elements can be sorted by id, type and name
- New tool to check for the correctness of element references and ability fix some errors automatically.

#v1.2.0
- GUI automatically adopts an horizontal layout to fit small displays (eg. typical laptops with a resolution of 1366 x 768) 

#v1.0.0

- Supports working with two estab files simultaneously: one estab that is opened in read-only mode (referred to as the source estab); and a second estab that is opened for edition (referred to as the target estab).
- Elements in the source estab can be individually copied into the target estab.
	- Copy operations recursively detectes referred elements and brings the user the option to also copy referred elements (all or just a selection of elements). For example, if we copy a vehicle equipped with machineguns, it will offer the option to copy not just the vehicle but also the machineguns it is equipped with.
	- Copy operations detect and avoid duplicates.
- Supports standar CRUD operations (create, read, update, delete), but only in the target estab.
- Three methods to add elements to a estab:
	- Clone elements from source estab into target estab. The new element keeps the same id as the cloned element.
	- Copy element from target estab into a new element in the source estab. The new element gets a new id.
	- Create new element from scratch.
- Forces can be created from scratch, specifying all its parameters and equipment, but also by composition. When a force is specified as composed of other forces, some of its attributes (like personnel and staff capacity) are derived from the constituent forces, and the same happens with its equipment.
