package ru.beetlerat.db.DAO;

import ru.beetlerat.db.model.Author;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AuthorDAO {
    // Объект подключения к БД
    private Connection connection;

    public AuthorDAO(String user, String password) throws SQLException{
        // Подключение к БД
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/graph_schema",user,password);
    }

    public Author getAuthorFromTable(int id){
        Author answer=null;
        try {
            // Создать шаблон запроса поиска определения по id в текущей таблице
            PreparedStatement dataBaseRequest=connection.prepareStatement("SELECT author_id,author_name,author_surname,author_patronymic FROM graph_author WHERE author_id=?;");
            // Заполнить шаблон запроса, те места где стоит ?
            dataBaseRequest.setInt(1,id);

            // Выполнить SQL запрос возвращающий результат
            // ResultSet - инкапсулирует результать запроса к БД
            ResultSet dataBaseAnswer= dataBaseRequest.executeQuery();
            dataBaseAnswer.next(); // Выбрать первый элемент из результата запроса
            // Создать из ответа на запрос объект Definition
            answer=new Author(dataBaseAnswer.getInt("author_id"),dataBaseAnswer.getString("author_name"),dataBaseAnswer.getString("author_surname"),dataBaseAnswer.getString("author_patronymic"));
        } catch (SQLException throwables) {
            System.out.println("Ошибка бд: "+throwables);
        }
        return answer;
    }

    // Вернуть список всех таблиц хранящихся в БД
    public List<Author> getAllAuthors(){
        List<Author> authorsList = null;
        try {
            // Создать запрос поиска разных имен таблиц в БД
            Statement dataBaseRequest=connection.createStatement();
            ResultSet dataBaseAnswer=dataBaseRequest.executeQuery("SELECT author_id,author_name,author_surname,author_patronymic FROM graph_author;");
            // Записать результаты запроса в список
            authorsList=new LinkedList<Author>();
            while (dataBaseAnswer.next()){
                authorsList.add(new Author(dataBaseAnswer.getInt(1),dataBaseAnswer.getString(2),dataBaseAnswer.getString(3),dataBaseAnswer.getString(4)));
            }
        } catch (SQLException throwables) {
            System.out.println("Ошибка бд: "+throwables);
        }
        return authorsList;
    }
}
