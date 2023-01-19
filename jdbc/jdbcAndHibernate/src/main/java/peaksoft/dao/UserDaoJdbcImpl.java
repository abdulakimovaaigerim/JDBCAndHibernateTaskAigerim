package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    private final Util util = new Util();
    @Override
    public void createUsersTable() {
        String query = "create table users(id serial primary key, name varchar, last_name varchar, age int";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is created on database!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void dropUsersTable() {
        String query = "drop table users: ";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
            System.out.println("Table deleted on database!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into users(name, last_name, age) values (?,?,?)";
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, String.valueOf(age));

            preparedStatement.executeUpdate();
            System.out.println("Users "+name+"saved successfully!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        String query = "delete from users where id = ?;";
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            System.out.println("Successfully deleted user by id!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        String query = "select * from users;";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<User> usersList = new ArrayList<>();
            while (resultSet.next()) {
                usersList.add(new User());
                resultSet.getString("first_name");
                resultSet.getString("last_name");
                resultSet.getString("age");

            }
            return usersList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        String query = "truncate table users;";
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is truncate on database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}