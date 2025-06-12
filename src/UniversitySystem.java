import java.util.List;
import java.util.Arrays;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class UniversitySystem {
    static List<ScheduleEntry> schedule = new ArrayList<>();
    static Map<Integer, Student> students = new HashMap<>();
    static List<Teacher> teachers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();

        System.out.println("Добро пожаловать в университетскую систему!");
        System.out.print("Введите ваш ID студента (1-5): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = students.get(id);
        if (student == null) {
            System.out.println("Студент с таким ID не найден.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n=== Меню студента ===");
            System.out.println("1. Показать мое расписание");
            System.out.println("2. Показать расписание преподавателя");
            System.out.println("3. Показать все мои оценки");
            System.out.println("4. Показать оценки по предмету");
            System.out.println("5. Показать мои задолженности");
            System.out.println("6. Показать мою посещаемость");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");
        }
        