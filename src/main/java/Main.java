import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Регистрация");
            System.out.println("2. Авторизация");
            System.out.println("3. Выйти из учетной записи");
            System.out.println("4. Закрыть приложение");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String regPassword = scanner.nextLine();

                    if (UserDAO.registerUser(regUsername, regPassword)) {
                        System.out.println("Регистрация прошла успешно.");
                    } else {
                        System.out.println("Ошибка при регистрации.");
                    }
                    break;
                case 2:
                    System.out.print("Введите имя пользователя: ");
                    String authUsername = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String authPassword = scanner.nextLine();

                    if (UserDAO.authorizeUser(authUsername, authPassword)) {
                        System.out.println("Авторизация успешна.");
                    } else {
                        System.out.println("Ошибка авторизации.");
                    }
                    break;
                case 3:
                    // Выход из учетной записи
                    System.out.println("Выход из учетной записи.");
                    break;
                case 4:
                    System.out.println("Закрытие приложения.");
                    System.exit(0); // Завершаем выполнение приложения
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
