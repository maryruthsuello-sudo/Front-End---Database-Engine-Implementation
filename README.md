# Front-End---Database-Engine-Implementation
Front End - Database Engine Implementation - Information Management

# How to integrate backend

**Step 1**
- Go to `StartDatabase.java` and modify password and name of database.

**Step 2**
- Input this on where you are going to run the database `StartDatabase startDb = new StartDatabase();`

**Step 3**
- Using `startDb` call the method `getDb` followed by the table you need to acces and the operation you need.
- Example: `startDb.getDb().getStudent().createStudent()` // input the needed parameters