package ru.beetlerat.db.DAO;

import ru.beetlerat.db.model.Graph;

import java.util.List;

public class GraphsDAO {
    public Graph findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Graph.class, id);
    }

    public List<Graph> findAll() {
        List<Graph> graphList = (List<Graph>) HibernateUtil.getSessionFactory().openSession().createQuery("From Graph").list();
        return graphList;
    }
}
