public class WeeklyRentalStrategy implements RentalStrategy{
    
    private double weeklyRate;

    public WeeklyRentalStrategy(double weeklyRate){
        this.weeklyRate = weeklyRate;
    }

    @Override
    public double calculatePrice(int days){
        return weeklyRate * Math.ceil(days / 7);
    }
}
