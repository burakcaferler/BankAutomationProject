import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account {

    private String AccountType;
    private double balance;
    private int amount;
    private int id;
    public String date;

    Scanner scan = new Scanner(System.in);

    public String GetAccountType(){
        return AccountType;
    }

    public void SetAccountType(String AccountType){
        this.AccountType = AccountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double deposit(){
        System.out.print("Yat�rmak �stedi�iniz Tutar� Giriniz: ");
        amount = scan.nextInt();
        do {

            if (amount < 0) {

                System.out.println("Ge�ersiz ��lem Tekrar Deneyiniz. ");
                System.out.print("Yat�rmak �stedi�iniz Tutar� Giriniz: ");
                amount = scan.nextInt();
            }

        }
        while(amount < 0);
        balance = balance + amount;
        System.out.println("��lem ba�ar�l�!");
        System.out.println("Yeni bakiyeniz:"+ getBalance());
        return balance;
    }

    public void withdraw(){

        System.out.print("�ekmek �stedi�iniz Tutar� Giriniz: ");
        int tutar = scan.nextInt();
        if(getBalance() >= tutar && tutar >= 0) {
            balance = balance - tutar;
            System.out.println("Kalan Hesap Bakiyeniz: " + getBalance());

        }

        else if(tutar < 0)

        {

            System.out.println("L�tfen ge�erli bir say� giriniz ");

        }
        else  {

            System.out.println(" Hesap Bakiyenizde "+ tutar +" TL Tutar�nda Para Mevcut De�ildir. ");

        }
    }
    
   

    public void getDate()
    {
    	String date = "2022-02-14";
    	System.out.println("Sistemin �u an ki tarihi: "+date);
    }
    public void Benefit(double interestrate, AccountUser accountUser){
        double dailybenefit;
        double annualbenefit;
        double newamount;
        final double daysofyear = 365.0;


        String date = "2022-02-14";
        LocalDate time = LocalDate.parse(date);
        LocalDate fat = LocalDate.now();
        System.out.println("Yat�rmak istedi�iniz tutar� giriniz:  ");
        newamount = scan.nextDouble();
        accountUser.setBalance(newamount);
        newamount = newamount + accountUser.getBalance();
        dailybenefit = (newamount/100)*(interestrate/daysofyear);
        System.out.println("G�nl�k getiri: " + dailybenefit + "TL");
        annualbenefit=dailybenefit*daysofyear;
        System.out.println("Y�ll�k getiri: " + annualbenefit + "TL");
        System.out.println("Bug�ne kadar elde edilen k�r: " + (dailybenefit*(fat.getDayOfYear()-time.getDayOfYear())) + "TL");

    }

    public static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}