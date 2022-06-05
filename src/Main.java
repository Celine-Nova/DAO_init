import dao.impl.ClientDao;
import dao.interfaces.IClientDao;
import models.Client;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClientDao clientDao=new ClientDao();
//        ArrayList<Client> clients=clientDao.getAll();
//        for(Client client:clients){
//            System.out.println(client);
//        }
//        Client client = clientDao.getById(5);
//        System.out.println(client);
        Client newClient = new Client("M2i formation", "COCO", "NUTS", "cn@gmail.com","0335693556856","rue fkglmtr", "30698", "Monaco", "France", 5);

       clientDao.save(newClient);
//      clientDao.update(updateClient);
//        DELETE
//        clientDao.delete(5);

    }

}