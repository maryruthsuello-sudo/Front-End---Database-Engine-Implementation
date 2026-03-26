# Front-End---Database-Engine-Implementation
Front End - Database Engine Implementation - Information Management

# How to connect database

**Step 1**
- In `backend/StartDatabase.java` change `dbName` to name of database in your PostgreSQL
- In `backend/StartDatabase.java` change `password` to your password in PostgreSQL

**Step 2**
- Open your terminal and compile
```javac -cp "databaseengine\backend\lib\postgresql-42.7.10.jar" -d databaseengine\out databaseengine\backend\*.java databaseengine\backend\model\*.java```

**Step 3**
- After compiling, run this
```java -cp "databaseengine\out;databaseengine\backend\lib\postgresql-42.7.10.jar" databaseengine.backend.StartDatabase```

