package ru.beetlerat.db.model;

public class Author {
    // Хранимые данные
    private int id;
    private String name;
    private String surname;
    private String patronymic;

    // Конструкторы
    public Author(){
        id=0;
        name="Имя не задано";
        surname="Фамилия не задана";
        patronymic="Отчество не заданно";
    }
    public Author(int id, String name, String surname, String patronymic) {
        this.id = id;
        if (name==null){
            this.name="Имя не задано";
        }
        else {
            this.name = name;
        }
        if (surname==null){
            this.surname="Фамилия не задана";
        }
        else {
            this.surname = surname;
        }
        if (patronymic==null){
            this.patronymic="Отчество не задано";
        }
        else {
            this.patronymic = patronymic;
        }
    }

    // Геттеры
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPatronymic() {
        return patronymic;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
