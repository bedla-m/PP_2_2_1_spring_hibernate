package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        Car car1 = new Car("BMW", 1990);
        Car car2 = new Car("Volvo", 1987);
        Car car3 = new Car("Ford Mustang", 1969);

        user1.setCar(car1);
        car1.setUser(user1);

        user2.setCar(car2);
        car2.setUser(user2);

        user3.setCar(car3);
        car3.setUser(user3);

       /* Также была идея добавить Car в конструктор юзера, но посчитал что
       задача требует именно расписать взаимодействия между класса
       */

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
            }
        System.out.println("Пользователь найден: ");
        System.out.println(userService.getUserByCar("BMW", 1990).toString());
        context.close();
    }
}
