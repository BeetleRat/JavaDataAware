package ru.beetlerat.db;

import ru.beetlerat.db.UI.AppFrame;

import javax.swing.*;

public class DB {


    public static void main(String args[]) {
        // Создать форму в потоке диспетчерезации событий через анонимный класс
        SwingUtilities.invokeLater(new Runnable() {
            // Перегрузка методов интерфейса
            public void run() {
                // Создание формы в парралельном потоке Swing
                new AppFrame();
            }
        });
    }
}
