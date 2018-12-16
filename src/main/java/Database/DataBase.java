package Database;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

/**
 Types of SQL DBs we have

 1. MySQL
 2. SQL Server
 3. Oracle
 4. SQLite
 5. PostgreSQL
 6. MariaDB
 7. MS Access
 */


public class DataBase {

    public Connection con = null;
    public Statement  smt = null;
    public ResultSet  rst = null;

    public String Database;


    //Constructors
    public DataBase(String DataBase){
        this.Database = DataBase;
    }



    @BeforeClass
    public void initiate_DBConnection() throws ClassNotFoundException {

        try {

            String dbURL = "jdbc:mysql://localhost:3306/Zia";
            String userName = "root";
            String password = null;

            con = DriverManager.getConnection(dbURL, userName, password);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    @Test
    public void DBTest () throws SQLException {

            smt = con.createStatement();

            rst = smt.executeQuery("Select * from Table1");

            while (rst.next()){
                String Sname = rst.getString(1);
                String Class = rst.getString(2);
                String Marks = rst.getString(3);

                System.out.println(Sname+"  "+Class+"   "+Marks);
            }
    }

    @Test
    public void getMarks () throws SQLException {

        smt = con.createStatement();

        rst = smt.executeQuery("Select * from Table1");

        while (rst.next()){
            String Sname = rst.getString(1);
            if (Sname.trim().contains("Beta")){
                String Marks = rst.getString(3);
                System.out.println(Marks);
            }
        }
    }



    @Test
    public void studentMarks() throws SQLException {

        getMarks("Beta");
    }



    @Test
    public void getMarks (String Student_name) throws SQLException {

        smt = con.createStatement();

        rst = smt.executeQuery("Select * from Table1");

        while (rst.next()){
            String Sname = rst.getString(1);

            if (Sname.trim().contains(Student_name)){
                String Marks = rst.getString(3);
                System.out.println(Marks);
            }
        }
    }

    @Test
    public void dataBaseUpdate () throws SQLException {
        insertData("Jack",3,89);

    }


        @Test
    public void insertData (String Student_name, int ClassI, int MarksI) throws SQLException {

        try {
            PreparedStatement pst = con.prepareStatement("Insert into Table1(S_name, Class, Marks) values ('"+Student_name+"','"+ClassI+"','"+MarksI+"')");

            pst.executeUpdate();

        }catch(Exception e){
            System.out.println(e.toString());

        }

    }



    ;





    @AfterClass
    public void close_DBConnection() throws SQLException {
        con.close();
    }


}
