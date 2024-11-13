package org.example;

import org.example.role.Role;
import org.example.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаем список ролей
        List<Role> roles = List.of(
                new Role("Admin", 1),
                new Role("Moderator", 2),
                new Role("User", 3),
                new Role("Guest", 4)
        );

        // Создаем список пользователей
        List<User> users = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            String name = "User" + i;
            String surname = "Surname" + i;
            String login = "user" + i;
            String password = "pass" + i;
            LocalDate dateJoined = LocalDate.now().minusDays(rand.nextInt(800)); // Случайная дата до 800 дней назад
            User user = new User(name, surname, login, password, dateJoined);

            // Назначаем случайные 1-3 роли каждому пользователю
            for (int j = 0; j < rand.nextInt(3) + 1; j++) {
                user.addRole(roles.get(rand.nextInt(roles.size())));
            }
            users.add(user);
        }

        // Присваиваем VIP-статус пользователям, которые присоединились более года назад
        for (User user : users) {
            if (user.getDaysSinceJoined() > 365) {
                user.setStatus("vip");
            }
        }

        // Находим пользователя с самой старой датой регистрации
        User oldestUser = users.stream().min(Comparator.comparing(User::getDateJoined)).orElse(null);
        System.out.println("User with the oldest join date: " + oldestUser);

        // Находим пользователей с минимальным приоритетом роли
        int highestPriority = roles.stream().mapToInt(Role::getPriority).max().orElse(4);
        System.out.println("\nUsers with the lowest role priority:");
        for (User user : users) {
            if (user.getRoles().stream().anyMatch(role -> role.getPriority() == highestPriority)) {
                System.out.println(user);
            }
        }

        // Подсчитываем количество пользователей для каждой роли
        Map<String, Integer> roleCounts = new HashMap<>();
        for (Role role : roles) {
            int count = (int) users.stream().filter(user -> user.getRoles().stream().anyMatch(r -> r.getName().equals(role.getName()))).count();
            roleCounts.put(role.getName(), count);
        }

        System.out.println("\nRole counts:");
        roleCounts.forEach((roleName, count) -> System.out.println(roleName + ": " + count));
    }
}