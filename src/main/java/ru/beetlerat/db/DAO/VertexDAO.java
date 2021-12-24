package ru.beetlerat.db.DAO;


import ru.beetlerat.db.model.Author;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class VertexDAO {
    // Объект подключения к БД
    private Connection connection;


    public VertexDAO(String user, String password) throws SQLException{
        // Подключение к БД
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/graph_schema",user,password);
    }



    public ResultSet getVertexResultFromTable(int id){
        ResultSet dataBaseAnswer=null;
        try {
            // Создать шаблон запроса поиска определения по id в текущей таблице
            PreparedStatement dataBaseRequest=connection.prepareStatement("SELECT vertex_id,vertex_name,vertex_width,vertex_height,x_coord,y_coord FROM vertex WHERE author_id=?;");
            // Заполнить шаблон запроса, те места где стоит ?
            dataBaseRequest.setInt(1,id);

            // Выполнить SQL запрос возвращающий результат
            // ResultSet - инкапсулирует результать запроса к БД
            dataBaseAnswer= dataBaseRequest.executeQuery();
        } catch (SQLException throwables) {
            System.out.println("Ошибка бд: "+throwables);
        }
        return dataBaseAnswer;
    }

    // Вернуть список всех таблиц хранящихся в БД
    public ResultSet getAllVertexResult(){
        ResultSet dataBaseAnswer=null;
        try {
            // Создать запрос поиска разных имен таблиц в БД
            Statement dataBaseRequest=connection.createStatement();
            dataBaseAnswer=dataBaseRequest.executeQuery("SELECT vertex_id,vertex_name,vertex_width,vertex_height,x_coord,y_coord FROM vertex;");
        } catch (SQLException throwables) {
            System.out.println("Ошибка бд: "+throwables);
        }
        return dataBaseAnswer;
    }
}
