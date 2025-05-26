public class EnumerationExample {
    public enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        public boolean workDay() {
            return this != SUNDAY && this != SATURDAY;
        }
    }

    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + " is a workday: " + day.workDay());
        }
    }
}

OUTPUT 
SUNDAY is a workday: false
MONDAY is a workday: true
TUESDAY is a workday: true
WEDNESDAY is a workday: true
THURSDAY is a workday: true
FRIDAY is a workday: true
SATURDAY is a workday: false
