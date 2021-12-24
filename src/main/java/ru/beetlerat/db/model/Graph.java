package ru.beetlerat.db.model;

import javax.persistence.*;

@Entity
@Table(name = "graph")
public class Graph {
    // Указываем поле id в качестве ID
    @Id
    // Автогенерация поля id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "graph_id")
    private int id;

    @Column(name = "graph_name", length = 30)
    private String name;

    @Column(name = "author_id")
    private int authorID;

    @Column(name = "vertex_count")
    private int vertexCount;

    // Конструкторы
    public Graph(){
        id=0;
        name=null;
        authorID=0;
        vertexCount=0;
    }

    public Graph(int id, String name, int authorID, int vertexCount) {
        this.id = id;
        this.name = name;
        this.authorID = authorID;
        this.vertexCount = vertexCount;
    }

    // Геттеры
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAuthorID() {
        return authorID;
    }
    public int getVertexCount() {
        return vertexCount;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }
}
