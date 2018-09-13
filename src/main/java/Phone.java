public class Phone {
    private String _model;
    private int _price;
    private String _madeBy;

    public void set_Car (String model, int price, String madeBy){
        this._model = model;
        this._price = price;
        this._madeBy = madeBy;
    }

    public int get_price() {
        return _price;
    }

    public String get_madeBy() {
        return _madeBy;
    }

    public String get_price_and_madeBy(){
        return "This car has price "+this._price+" and made by "+ this._madeBy;

    }
}
