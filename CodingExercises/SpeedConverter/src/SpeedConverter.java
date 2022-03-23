
public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour){
        if (kilometersPerHour < 0){
            return -1;
        } else {
            //calculate the value of miles per hour
            double milesPerHour = kilometersPerHour / 1.609;
            //round it and return
            return Math.round(milesPerHour);
        }
    }

    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour < 0){
            System.out.println("Invalid Value");
        } else {
            double milesPerHour = toMilesPerHour(kilometersPerHour);
            long milesPerHourR = Math.round(milesPerHour);
            System.out.println(kilometersPerHour + " km/h = " + milesPerHourR + " mi/h");
        }
    }
}
