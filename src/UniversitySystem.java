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

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1 -> showStudentSchedule(student);
                            case 2 -> showTeacherSchedule();
                            case 3 -> student.showAllGrades();
                            case 4 -> {
                                System.out.print("Введите название предмета: ");
                                String subject = scanner.nextLine();
                                student.showGradesBySubject(subject);
                            }
                            case 5 -> student.showDebts();
                            case 6 -> student.showAttendance();
                            case 0 -> running = false;
                            default -> System.out.println("Неверный выбор!");
                        }
                    }
                }

                static void showStudentSchedule(Student student) {
                    System.out.println("\n=== Ваше расписание ===");
                    Map<DayOfWeek, List<ScheduleEntry>> grouped = schedule.stream()
                            .collect(Collectors.groupingBy(e -> e.day));

                    for (DayOfWeek day : DayOfWeek.values()) {
                        List<ScheduleEntry> entries = grouped.get(day);
                        if (entries != null) {
                            System.out.println("\n" + day + ":");
                            for (ScheduleEntry entry : entries) {
                                System.out.println(entry);
                            }
                        }
                    }
                }

                static void showTeacherSchedule() {
                    System.out.print("Введите имя преподавателя: ");
                    String name = scanner.nextLine();
                    boolean found = false;
                    for (ScheduleEntry entry : schedule) {
                        if (entry.teacher.name.equalsIgnoreCase(name)) {
                            if (!found) {
                                System.out.println("\n=== Расписание преподавателя ===");
                                found = true;
                            }
                            System.out.println(entry);
                        }
                    }
                    if (!found) System.out.println("Преподаватель не найден или нет расписания.");
                }

                static void seedData() {
                    Teacher vasilieva = new Teacher("Васильева", "Программирование на Java");
                    Teacher nikolaev = new Teacher("Николаев", "Математический анализ");
                    Teacher pavlova = new Teacher("Павлова", "Английский язык");
                    Teacher sokolov = new Teacher("Соколов", "Базы данных");

                    teachers.addAll(List.of(vasilieva, nikolaev, pavlova, sokolov));

                    schedule.add(new ScheduleEntry(DayOfWeek.MONDAY, LocalTime.of(9, 0), "Программирование на Java", vasilieva, "А-101"));
                    schedule.add(new ScheduleEntry(DayOfWeek.MONDAY, LocalTime.of(11, 0), "Математический анализ", nikolaev, "Б-205"));
                    schedule.add(new ScheduleEntry(DayOfWeek.TUESDAY, LocalTime.of(9, 0), "Английский язык", pavlova, "В-312"));
                    schedule.add(new ScheduleEntry(DayOfWeek.WEDNESDAY, LocalTime.of(13, 0), "Базы данных", sokolov, "А-102"));
                    schedule.add(new ScheduleEntry(DayOfWeek.FRIDAY, LocalTime.of(15, 0), "Алгоритмы и структуры данных", vasilieva, "А-105"));

                    students.put(1, new Student(1, "Анна Смирнова"));
                    students.put(2, new Student(2, "Игорь Иванов"));
                    students.put(3, new Student(3, "Мария Кузнецова"));
                    students.put(4, new Student(4, "Дмитрий Сидоров"));
                    students.put(5, new Student(5, "Ольга Попова"));

                    students.get(1).addGrade("Программирование на Java", 5);
                    students.get(1).addGrade("Математический анализ", 4);
                    students.get(1).addGrade("Английский язык", 3);
                    students.get(1).addAttendance("Программирование на Java", 9);
                    students.get(1).addAttendance("Математический анализ", 8);
                    students.get(1).addAttendance("Английский язык", 7);
                }
            }
