package ru.beetlerat.db.model;

public class Vertex {
    // Хранимые данные
    private int id;
    private String name;
    private int width;
    private int height;
    private int xCoord;
    private int yCoord;

    // Конструкторы
    public Vertex(){
        id=0;
        name="Имя не задано";
        width=0;
        height=0;
        xCoord=0;
        yCoord=0;
    }

    public Vertex(int id, String name, int width, int height, int xCoord, int yCoord) {
        this.id = id;
        if (name==null){
            this.name="Имя не задано";
        }
        else {
            this.name = name;
        }
        this.width = width;
        this.height = height;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    // Геттеры
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
