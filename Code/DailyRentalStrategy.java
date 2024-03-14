public class DailyRentalStrategy implements RentalStrategy{
    
    private double dailyRate;

    public DailyRentalStrategy(double dailyRate){
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculatePrice(int days){
        return dailyRate * days;
    }
}
