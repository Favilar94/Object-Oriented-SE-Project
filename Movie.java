public class Movie {

    public static final int CHILDRENS   = 2; //Primitive obsession -- Use instead enum
    public static final int REGULAR     = 0; //Primitive obsession -- Use instead enum
    public static final int NEW_RELEASE = 1; //Primitive obsession -- Use instead enum
    
    private String _title;
    private int    _priceCode;
    
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return _priceCode;
    }
    
    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    
    public String getTitle() {
        return _title;
    }
}