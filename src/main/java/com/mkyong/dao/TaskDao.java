package com.mkyong.dao;

import com.mkyong.stock.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {
   Session session;

//        session.beginTransaction();
//        session.save(new Task());
//        session.getTransaction().commit();
//        session.close();
    public TaskDao() throws SQLException, ClassNotFoundException {

    }

//    public List<Task> getAllTasks() throws SQLException {
//        List<Task> taskList = new ArrayList<>();
//        String sql = "SELECT * FROM `table`";
//        ResultSet rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            taskList.add(new Task(rs.getInt("id")
//                    , rs.getString("title")
//                    , rs.getString("details")
//                    , rs.getBoolean("view")
//                    , rs.getString("localTime")
//                    , rs.getString("currentDay")
//                    ,rs.getInt("list_id")));
//        }
//
//        return taskList;
//    }

    public void setView(String id) throws SQLException {

        String sql = "UPDATE `table` SET view = !view WHERE id=" + id;

    }

    public void delete(String id) throws SQLException {
        session.beginTransaction();
        TaskDao taskDao = (TaskDao) session.createCriteria(TaskDao.class).add(Restrictions.eq("id",id));
        session.delete(taskDao);
        session.getTransaction();
        session.close();

    }

//    public List<Task> viewDescription(String id) throws SQLException {
//        List<Task> taskList = new ArrayList<>();
//        String sql = "SELECT * FROM `table` WHERE id=" + id;
////        String sql = "SELECT `table`.id,title, details,view,`localTime`,currentDay,list.name FROM `table`,list WHERE list_id = list.id AND `table`.id LIKE1";
//        //SELECT title, details,view,`localTime`,currentDay,list.name FROM `table`,list WHERE list_id = list.id AND `table`.id LIKE '4'
////        ResultSet rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            taskList.add(new Task(rs.getInt("id")
//                    , rs.getString("title")
//                    , rs.getString("details")
//                    , rs.getBoolean("view")
//                    , rs.getString("localTime")
//                    , rs.getString("currentDay")
//                    ,rs.getInt("list_id")));
//        }
//
//    }

    public void addTask(String title, String details, String localDate, String currentTime,int task) throws SQLException {
        String sql = "INSERT INTO `table`(title, details, `localTime`, currentDay,list_id) VALUES ('" + title + "','" + details + "','" + localDate + "','" + currentTime + "','" + task +"');";

    }

//    public void setTask() throws SQLException {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        Integer employeeID = null;
//        tx = session.beginTransaction();
//        Task task =  new Task();
//        task.setTaskId(24);
//        task.setTitle("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQq");
//        task.setDetails("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWwwwww");
//        task.setView(true);
//        task.setLocalTime("1111111111111111111111111111111111111111");
//        task.setCurrentDay("2222222222222222222222222222222222222222222");
//        task.setList_id(1);
//        tx.commit();
////        List<ListName> listLists = new ArrayList<>();
////        String sql = "SELECT * FROM `list`";
////        ResultSet rs = stmt.executeQuery(sql);
////        while (rs.next()) {
////            listLists.add(new ListName(rs.getInt("id")
////                    , rs.getString("name")));
////        }
////        conn.close();
////        return listLists;
//    }

}