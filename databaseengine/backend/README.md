# How to connect database

**Step 1**
- In `backend/StartDatabase.java` change `dbName` to name of database in your PostgreSQL
- In `backend/StartDatabase.java` change `password` to your password in PostgreSQL

**Step 2**
- Open your terminal and compile
```javac -cp "databaseengine\backend\lib\postgresql-42.7.10.jar" -d out databaseengine\backend\StartDatabase.java```

**Step 3**
- After compiling, run this
```java -cp "out;databaseengine\backend\lib\postgresql-42.7.10.jar" databaseengine.backend.StartDatabase```
