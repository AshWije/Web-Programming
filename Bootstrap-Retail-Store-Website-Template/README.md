# Bootstrap Retail Store Website Template

This folder contains a template for a retail store's static website using Bootstrap, HTML, CSS, and JS.


**Order History Page**

Clicking any table header cell once will sort the table by that respective column in ascending order,
clicking that cell a second time will sort the table by that respective column in descending order.


**Shopping List Page**

Clicking a non-header cell that is also not in the delete row column will put that cell in edit mode (more specifically contentEditable=true).
	-This can also be seen in the background-color change of the cell (a cell being edited will have a grey background).

There are validation checks for the middle two column entries.
	-The second column (Item Quantity) entries must be integer values.
	-The third column (Item Required Date) entries must be a valid date of the form (YYYY/MM/DD).
	-If a validation check fails, the background-color of the cell will become red and an error message will appear.

When the user is finished editing a cell, they must click another cell on the table to stop editing (the background-color will become transparent).
Only one cell can be editable at a time.


2019