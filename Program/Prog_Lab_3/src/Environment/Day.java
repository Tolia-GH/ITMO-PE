package Environment;

public class Day {
    public int date;
    public Day() {
        this.date = 1;
        showDate(1);
    }

    public Day(int date) {
        this.date = date;
        showDate(date);
    }

    public void goNextDay() {
        System.out.println();
        this.date++;
        showDate(date);
    }

    public void showDate(int date) {
        System.out.print("On the " + date);
        switch (date % 10) {
            case 1:
                System.out.print("-st day.\n");
                break;
            case 2:
                System.out.print("-nd day.\n");
                break;
            case 3:
                System.out.print("-rd day.\n");
                break;
            default:
                System.out.print("-th day.\n");
                break;
        }
    }
}
