import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AuthenticationApp extends Application {

    private TextField usernameTextField;
    private PasswordField passwordField;
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Приложение для аутентификации");

        // Создаем макет VBox для главного окна
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-padding: 10px;");
        Scene scene = new Scene(vbox, 350, 250);

        // Создаем метки, текстовые поля и кнопки
        Label titleLabel = new Label("Система аутентификации");
        titleLabel.setStyle("-fx-font-size: 18px;");

        Label usernameLabel = new Label("Имя пользователя:");
        usernameTextField = new TextField();

        Label passwordLabel = new Label("Пароль:");
        passwordField = new PasswordField();

        Button registerButton = new Button("Зарегистрироваться");
        Button loginButton = new Button("Войти");

        // Добавляем обработчики событий для кнопок
        registerButton.setOnAction(e -> {
            String regUsername = usernameTextField.getText();
            String regPassword = passwordField.getText();

            if (UserDAO.registerUser(regUsername, regPassword)) {
                showMessage("Успешная регистрация", "Регистрация прошла успешно.");
                clearFields();
            } else {
                showMessage("Ошибка регистрации", "Ошибка во время регистрации.");
            }
        });

        loginButton.setOnAction(e -> {
            String authUsername = usernameTextField.getText();
            String authPassword = passwordField.getText();

            if (UserDAO.authorizeUser(authUsername, authPassword)) {
                showMessage("Успешный вход", "Авторизация прошла успешно.");
                clearFields();
            } else {
                showMessage("Ошибка входа", "Ошибка во время входа.");
            }
        });

        // Добавляем элементы пользовательского интерфейса в макет
        vbox.getChildren().addAll(titleLabel, usernameLabel, usernameTextField, passwordLabel, passwordField, registerButton, loginButton);

        // Устанавливаем сцену и отображаем окно
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields() {
        // Очищаем текстовые поля
        usernameTextField.clear();
        passwordField.clear();
    }

    private void showMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}