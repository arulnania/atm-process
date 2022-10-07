public class Denominations {
    private int two_thousands;
    private int five_hundreds;
    private int hundreds;
    public Denominations(int two_thousands, int five_hundreds, int hundreds){
        this.two_thousands = two_thousands;
        this.five_hundreds = five_hundreds;
        this.hundreds = hundreds;
    }
    public int getHundreds(){
        return hundreds;
    }
    public void setHundreds(int hundreds){
        this.hundreds = hundreds;
    }
    public int getTwo_thousands(){
        return two_thousands;
    }
    public void setTwo_thousands(int two_thousands){
        this.two_thousands = two_thousands;
    }
    public int getFive_hundreds(){
        return five_hundreds;
    }
    public void setFive_hundreds(int five_hundreds){
        this.five_hundreds = five_hundreds;
    }

}
