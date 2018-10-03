public class Phone {

    private String model;
    private int price;
    private String madeBy;

    public void set_Car (String model, int price, String madeBy){
        this.model = model;
        this.price = price;
        this.madeBy = madeBy;
    }

    public int get_price() {
        return price;
    }

    public String get_madeBy() {
        return madeBy;
    }

    public String get_price_and_madeBy(){
        return "This car has price "+this.price+" and made by "+ this.madeBy;

    }
}
