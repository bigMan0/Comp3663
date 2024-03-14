public class HourlyRentalStrategy implements RentalStrategy{
    
    private double hourlyRate;
    private double minimumHours;

    public HourlyRentalStrategy(double hourlyRate, double minimumHours){
        this.hourlyRate = hourlyRate;
        this.minimumHours = minimumHours;
    }

    @Override 
    public double calculatePrice(int hours){
        if (hours < minimumHours){
            throw new IllegalArgumentException("Minimum rental duration not met");
        }
        return hourlyRate * hours;
    }

}
