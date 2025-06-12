import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Student {
    int id;
    String name;
    Map<String, List<Integer>> grades = new HashMap<>();
    Map<String, Integer> attendance = new HashMap<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void addGrade(String subject, int grade) {
        grades.computeIfAbsent(subject, _ -> new ArrayList<>()).add(grade);
    }

    void addAttendance(String subject, int count) {
        attendance.put(subject, attendance.getOrDefault(subject, 0) + count);
    }

    void showAllGrades() {
        grades.forEach((subject, list) -> System.out.println(subject + ": " + list));
    }

    void showGradesBySubject(String subject) {
        List<Integer> list = grades.get(subject);
        if (list != null) {
            System.out.println(subject + ": " + list);
        } else {
            System.out.println("Нет оценок по предмету " + subject);
        }
    }

    void showAttendance() {
        attendance.forEach((subject, count) -> System.out.println(subject + ": " + count + " посещений"));
    }

    void showDebts() {
        grades.forEach((subject, list) -> {
            if (list.stream().anyMatch(g -> g < 4)) {
                System.out.println("Задолженность по предмету: " + subject);
            }
        });
    }
}
