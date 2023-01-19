package peaksoft;

import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl service = new UserServiceImpl();

        service.createUsersTable();

        System.out.println( "<<<COMMANDS>>>"+
                "1 button-> createUsersTable" +
                "2 button-> dropUsersTable" +
                "3 button-> saveUser" +
                "4 button-> removeUserById" +
                "5 button-> getAllUsers" +
                "6 button-> cleanUsersTable");

        while (true){
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    service.createUsersTable();
                    break;
                case 2:
                    service.dropUsersTable();
                    break;
                case 3:
                    service.saveUser("Aisonun", "Abdujaparova", (byte) 17);
                    break;
                case 4:
                    service.removeUserById(1);
                    break;
                case 5:
                    service.getAllUsers();
                    break;
                case 6:
                    service.cleanUsersTable();
                break;
                default:
                    System.out.println("Your method is complete!");
            }
        }

    }
}
