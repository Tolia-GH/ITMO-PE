package Environment;

public class Weather {
    public Status status;

    public enum Status {
        WARM_AND_SUNNY,
        COLD_AND_FOGGY,
        UNKNOWN;

        public String toString() {
            return super.toString().replace('_',' ').toLowerCase();
        }
    }

    public Weather() {
        this.status = Status.UNKNOWN;
    }

    public Weather(Status status) {
        this.status = status;
        System.out.println("The weather is " + status.toString() + ".");
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
        System.out.println("The weather changed into " + status.toString() + ".");
        if(this.status.equals(Status.COLD_AND_FOGGY)) {
            System.out.println("It's a really bad weather.");
        }
        if(this.status.equals(Status.WARM_AND_SUNNY)) {
            System.out.println("It's a good weather.");
        }
    }

    public boolean isBadWeather() {
        return this.status.equals(Status.COLD_AND_FOGGY);
    }

    public Status getStatus() {
        return this.status;
    }

    public class Fog {

        private int stage;

        public Fog() {
            this.stage = 1;
            System.out.println("It's getting foggy");
        }

        public void gettingThicker() {
            this.stage++;
            System.out.println("The fog is getting thicker");
        }

        public int getStage() {
            return this.stage;
        }
    }
}
