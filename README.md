### Kanban Board implementation in Java
## Bartłomiej Gordon INF sem 5
`⭐ Do not forget to give a star on GitHub!`

The main topic of the project was to create a Java backend for Kanban Board that can be used in a web browser. 

The program is connected to the local database at jdbc:derby://localhost:1527/lab
user: app
password: app

Example of the user interface:

![example1](https://user-images.githubusercontent.com/69083596/218280024-0357c0a2-2ec4-4594-b6e0-aca2d7e22a83.png)

![example2](https://user-images.githubusercontent.com/69083596/218280026-ec776d5c-5ebd-4689-8076-154b7da3eaf7.png)

## Code Highlights

### Two-Phase Insert with Generated Keys

```java
// src/main/java/pl/pols/lab/services/PersistentData.java
public void insertTask(String title, String description, String tableName) {
    try {
        PreparedStatement pstm;
        ResultSet rs;
        String query = "insert into tasks (title, description) values (?,?)";
        pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, title);
        pstm.setString(2, description);
        pstm.executeUpdate();
        rs = pstm.getGeneratedKeys();
        if (rs != null && rs.next()) {
            PreparedStatement pstmToDo;
            String queryToDo = "insert into " + tableName + " (task_id) values (?)";
            pstmToDo = con.prepareStatement(queryToDo);
            pstmToDo.setInt(1, rs.getInt(1));
            pstmToDo.executeUpdate();
        }
        System.out.println("Data inserted");
    } catch (SQLException sqle) {
        System.err.println(sqle.getMessage());
    }
}
```

Inserts a new task into the normalized `tasks` master table, immediately retrieves the auto-generated primary key via `Statement.RETURN_GENERATED_KEYS`, then uses that key to insert a foreign-key reference into the appropriate column junction table (`toDo`, `inProgress`, or `done`). This two-phase insert pattern correctly links records across a normalized relational schema without exposing the generated ID to the caller.

