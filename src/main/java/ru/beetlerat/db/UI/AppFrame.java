package ru.beetlerat.db.UI;

import net.proteanit.sql.DbUtils;
import ru.beetlerat.db.DAO.AuthorDAO;
import ru.beetlerat.db.DAO.GraphsDAO;
import ru.beetlerat.db.DAO.VertexDAO;
import ru.beetlerat.db.model.Author;
import ru.beetlerat.db.model.Graph;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class AppFrame {
    private JFrame mainFrame; // Отображаемая форма

    // Панели отображаемые на форме
    private JTabbedPane multiPanel; // Панель с вкладками
    private JTextArea hibernateTextArea;
    private JTextArea jdbcTextArea;
    private JTable jdbcTable;

    public AppFrame(){
        // Создать новый контейнер типа JFrame с подписью Запоминалка
        mainFrame = new JFrame("База данных");
        // Задать размеры формы
        mainFrame.setSize(550, 250);
        mainFrame.setResizable(false);
        // Установить действие при закрытии формы - завершить приложение
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Установить потоковый диспетчер компановки
        mainFrame.setLayout(new FlowLayout());

        // Создать панель с вкладками
        multiPanel = new JTabbedPane();
        // Установить размеры панели с вкладками
        multiPanel.setPreferredSize(new Dimension(500, 200));

        createElements();

        // Заполнить панель с вкладками
        fillTabbedPane();

        // Добавить панель с вкладками на форму
        mainFrame.add(multiPanel);

        // Отобразить форму
        mainFrame.setVisible(true);
    }

    private void createElements(){
        hibernateTextArea=new JTextArea();
        jdbcTextArea=new JTextArea();
        jdbcTable=new JTable();

        try {
            AuthorDAO authorDAO=new AuthorDAO("root","iloveranbows44");
            List<Author> authorList=authorDAO.getAllAuthors();
            VertexDAO vertexDAO=new VertexDAO("root","iloveranbows44");
            GraphsDAO graphsDAO=new GraphsDAO();
            List<Graph> graphList = graphsDAO.findAll();

            // Присвоение источника данных DataAware компоненту
            jdbcTable.setModel(DbUtils.resultSetToTableModel(vertexDAO.getAllVertexResult()));
            String text="";

            for(Author author:authorList){
                text=text+"ID: "+author.getId()+"; Имя: "+author.getName()+"; Фамилия: "+author.getSurname()+"; Отчество: "+author.getPatronymic()+"\n";
            }
            jdbcTextArea.setText(text);

            text="";
            for(Graph graph:graphList){
                text=text+"ID: "+graph.getId()+"; Название графа: "+graph.getName()+"; Кол-во вершин: "+graph.getVertexCount()+"; ID автора: "+graph.getAuthorID()+"\n";
            }
            hibernateTextArea.setText(text);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Заполнить панель с вкладками
    private void fillTabbedPane() {
        // Добавлеяем панели на панель со вкладками
        multiPanel.addTab("строка связи",new JScrollPane(jdbcTextArea));
        multiPanel.addTab("строка связи DataGridView", new JScrollPane(jdbcTable));
        multiPanel.addTab("ORM",new JScrollPane(hibernateTextArea));
    }
}
