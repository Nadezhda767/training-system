import java.util.*;
import java.time.*;
class ScheduleEntry {
    DayOfWeek day;
    LocalTime time;
    String subject;
    Teacher teacher;
    String room;

    ScheduleEntry(DayOfWeek day, LocalTime time, String subject, Teacher teacher, String room) {
        this.day = day;
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
    }

    public String toString() {
        return String.format("%02d:00 - %02d:30 | %s | %s | Ауд. %s", time.getHour(), time.getHour() + 1, subject, teacher.name, room);
    }
}