package dao.impl;

import dao.interfaces.IClientDao;
import models.Client;
import service.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class ClientDao implements IClientDao {

    @Override
    public ArrayList<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String companyName = resultSet.getString("companyName");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String zipCode = resultSet.getString("zipCode");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                int state = resultSet.getInt("state");

                clients.add(new Client(id, companyName, firstName, lastName, email, phone,
                        address, zipCode, city, country, state));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client getById(int id) {
        Client client = null;
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM clients WHERE id= ?");
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {

                String companyName = resultSet.getString("companyName");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String zipCode = resultSet.getString("zipCode");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                int state = resultSet.getInt("state");

                client = (new Client(id, companyName, firstName, lastName, email, phone,
                        address, zipCode, city, country, state));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void save(Client client) {

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO clients(companyName, firstName, lastName, email, phone, address, zipCode, city, country, state) VALUES(?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, client.getCompanyName());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getEmail());
            statement.setString(5, client.getPhone());
            statement.setString(6, client.getAddress());
            statement.setString(7, client.getZipCode());
            statement.setString(8, client.getCity());
            statement.setString(9, client.getCountry());
            statement.setInt(10, client.getState());

            statement.executeUpdate();
            System.out.println("client CREE avec succés");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement("UPDATE clients SET  companyName = ?, firstName = ?, lastName = ?, email = ?, phone = ?, address = ?, zipCode = ?, city = ?, country = ?, state = ? WHERE id = " + client.getId());
            // Code REPETITIF avec la methode "methode save" REFACTORER
            statement.setString(1, client.getCompanyName());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getEmail());
            statement.setString(5, client.getPhone());
            statement.setString(6, client.getAddress());
            statement.setString(7, client.getZipCode());
            statement.setString(8, client.getCity());
            statement.setString(9, client.getCountry());
            statement.setInt(10, client.getState());

            statement.executeUpdate();
            System.out.println("client MODIFIE avec succés");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Client client = null;
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clients WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("client SUPPRIME avec succés");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}