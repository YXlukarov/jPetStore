package org.csu.mypetstore.persistence;
import java.sql.*;

public class DBUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mypetstore";
    private static String username = "root";
    private static String password = "123456";

    public static Connection getConnection() throws Exception{
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) throws Exception{
        if (connection != null){
            connection.close();
        }
    }

    public static void closeStatement(Statement statement) throws Exception{
        if(statement != null){
            statement.close();
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws Exception{
        if(preparedStatement != null){
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet)throws Exception{
        if(resultSet != null){
            resultSet.close();
        }
    }
}
