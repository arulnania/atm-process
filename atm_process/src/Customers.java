class Customers{
    private int acc_no;
    private String name;
    private String pin;
    private int acc_balance;
    public Customers(int acc_no, String name, String pin, int acc_balance){
        this.acc_no = acc_no;
        this.name = name;
        this.pin = pin;
        this.acc_balance = acc_balance;
    }
    public int getAcc_no(){
        return acc_no;
    }
    public void setAcc_no(int acc_no){
        this.acc_no = acc_no;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPin(){
        return pin;
    }
    public void setPin(String pin){
        this.pin = pin;
    }
    public int getAcc_balance(){
        return acc_balance;
    }
    public void setAcc_balance(int acc_balance){
        this.acc_balance = acc_balance;
    }
}