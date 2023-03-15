import java.util.concurrent.TimeUnit;
import java.util.Scanner;




public class Bank {
    public AccountUser[] hesaplarim;
    private int currentIndex = 0;
    private Scanner scan;
    public Account account;

    public Bank(){
        scan = new Scanner(System.in);
        hesaplarim = new AccountUser[5];
        AccountUser hesap = hesapac("Ana Hesap",Account.generateRandom(9));
        hesaplarim[currentIndex++] = hesap;
        
    }

    public void Create_S_ID_balance(){


        System.out.println("Ana Hesap Bakiyeniz: " + hesaplarim[0].getBalance());

        if(hesaplarim[0].getBalance()>=1000)
        {
            hesaplarim[1] = new AccountUser("K�sa Vadeli Hesap",Account.generateRandom(9));
            System.out.println(" K�sa vadeli hesab�n�z a��l�yor..." + "\n Hesap numaran�z: \n " + hesaplarim[1].getId());
            hesaplarim[1].Benefit(17,hesaplarim[1]);
        }
        else
            System.out.println(" 1000 TL'nin alt�nda hesap a�amazs�n�z . L�tfen yeterli paray� yat�r�n�z.");

    }

    public void Create_L_ID_balance(){
        System.out.println("Ana Hesap Bakiyeniz: "+ hesaplarim[0].getBalance());

        if(hesaplarim[0].getBalance() >= 1500)
        {
            hesaplarim[2] = new AccountUser("Uzun Vadeli Hesap",Account.generateRandom(9));
            System.out.println("Uzun vadeli hesab�n�z a��l�yor"+"\n Hesap numaran�z \n"+ hesaplarim[2].getId());
            hesaplarim[2].Benefit(24,hesaplarim[2]);
        }
        else{

            System.out.println("1500 TL'nin alt�nda hesap a�amazs�n�z. L�tfen yeterli paray� yat�r�n�z.");
        }
    }

    public void Create_O_ID_balance(){
        
        hesaplarim[3] = new AccountUser("Ozel Hesap",Account.generateRandom(9));
        System.out.println("�zel hesab�n�z a��l�yor");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        System.out.println("Hesap numaran�z:"+hesaplarim[3].getId());
        hesaplarim[3].Benefit(12,hesaplarim[3]);

    }
    public void Create_C_ID_balance()
    {
    	
    	hesaplarim[4] = new AccountUser("Cari Hesap",Account.generateRandom(9));
        System.out.println("Cari hesab�n�z a��l�yor");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        System.out.println("Hesap numaran�z:"+hesaplarim[4].getId());
        hesaplarim[4].Benefit(0,hesaplarim[4]);
    }

    public void Increase_ID_cash(AccountUser accountUser,double cash){
        if(cash >= 0)
        accountUser.deposit();
        else{
            System.out.println("L�tfen ge�erli bir tutar giriniz."); 
        }
    }

    public void Decrease_ID_cash(AccountUser accountUser,double cash){
        
        if(cash > hesaplarim[currentIndex].getBalance())
        accountUser.withdraw();
        else{
            System.out.println("Bu hesap t�r�n�zde �ekilecek yeterli bakiye bulunmamaktad�r."); 
        }
    }

   
    

    public void ShowAccount(){
        for (int i = 0; hesaplarim[i] != null ; i++){
            System.out.println("Hesap Turu: " + hesaplarim[i].GetAccountType());
            System.out.println("Hesap Numarasi: " + hesaplarim[i].getId());
            System.out.println("Hesap Bakiyesi: " + hesaplarim[i].getBalance());
            System.out.println("----------------");
        }
    }

    public void ShowIDs(){
        for (int i = 0; i < hesaplarim.length ; i++){
            System.out.println("Hesap Numarasi: " + hesaplarim[i].getId());
            System.out.println("----------------");
        }
    }
    
    
    
    public void Set_dd_mm_yy(){
        System.out.println("De�i�tirmek istedi�iniz tarihini yaz�n�z:");
    	System.out.println("G�n� giriniz(Say�yla): ");
    	
    	int day = scan.nextInt();
    	System.out.println("Ay� giriniz: ");
    	int month= scan.nextInt();
    	System.out.println("Y�l� giriniz:");
    	int year = scan.nextInt();
    	if(day>0 || day<32||month>1 || month<13||year>0)
    	{
        System.out.println("G�ncel tarih: "+year+"-"+month+"-"+day);
        }
    	else
    	 System.out.println("L�tfen ge�erli bir say� giriniz. ");
    	
    	
        
        

    }
    

    public void login(){

        int password;
        System.out.println("Merhaba Bankam�za Ho�geldiniz");
        System.out.println("Bankam�z�n size �zel tekliflerini ��renmek i�in l�tfen 0212 544 20 85 numaral� m��teri hizmetlerimizden yard�m al�n�z");
        System.out.println("L�tfen �ifrenizi giriniz:");
        password = scan.nextInt();
        System.out.println("L�tfen bekleyiniz...");
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
            System.out.println("Oops! Something went wrong!");
        }
        for (int i = 1; i <4; i++) {
            if (password==123321){
                try {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (Exception e) {
                    System.out.println("Oops! Something went wrong!");
                }
                System.out.println("�ifreniz do�ru,ba�ar�l� bir �ekilde giri� yapt�n�z!");
                break;
            }
            else if (i==3) {
                System.out.println("�ok Say�da Hatal� �ifre Girdiniz Sistemden ��k�l�yor...");
                System.exit(0);
            }
            else {
                System.err.println("Hatal� �ifre Girdiniz!");
                System.err.println("L�tfen �ifrenizi giriniz:");
                password=scan.nextInt();

            }
        }        
        while(true)
            switch(menu()) {
                case 1:
                    AccountTypeSelection(1);
                    break;
                case 2:
                    AccountTypeSelection(2);
                    break;
                case 3:
                    Create_S_ID_balance();
                    break;
                case 4:
                    Create_L_ID_balance();
                    break;
                case 5:
                    Create_O_ID_balance();
                    break;
                case 6:
                	Create_C_ID_balance();
                	break;
                case 7:
                    ShowAccount();
                    break;
                case 8:
                	Set_dd_mm_yy();
                	break;
                
                
                	
                default:
                    System.out.println("��k�� yap�l�yor  \n");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch (Exception e) {
                        System.out.println("Oops! Something went wrong!");
                    }
                    System.out.println("��k�� yap�ld�. ");
                    System.exit(0);
                    break;
                    

            }}

    public int menu(){

        System.out.println("1.Para yat�rma");
        System.out.println("2.Para �ekme");
        System.out.println("3.K�sa vadeli hesap a�ma---------->Bu hesap t�r� y�ll�k %17 faiz verir fakat hesab�n�zda en az 1000 TL bakiye olmas� gerekiyor");
        System.out.println("4.Uzun vadeli hesap a�ma---------->Bu hesap t�r� y�ll�k %24 faiz verir fakat hesab�n�zda en az 1500 TL bakiye olmas� gerekiyor.");
        System.out.println("5.�zel hesap a�ma ---------------->Bu hesap t�r� y�ll�k %12 faiz verir fakat hesap a��ld���nda mevcut olan bakiyeniz kadar bakiyeniz bulunmas� gerekiyor.");
        System.out.println("6.Cari hesap a�ma---------------->Bu hesap t�r� faizsizdir ve hesapta para olma zorunlulu�u yoktur. ");
        System.out.println("7.Hesaplar�m� G�r�nt�le");
        System.out.println("8. Tarih ayarlar� ");
        System.out.println("9. ��k�� ");
        System.out.print("L�tfen yapmak istedi�iniz i�lemi se�iniz: ");
        int value=scan.nextInt();
        if(value < 0 || value > 9){

            System.out.println("L�tfen ge�erli bir i�lem se�iniz.");
            value=scan.nextInt();
        }
        return value;
    }

    public AccountUser hesapac(String hesapturu,Object accountid){

        AccountUser hesap = new AccountUser(hesapturu,accountid);
        return hesap;
    }

    public void AccountTypeSelection(int number){

    	 if (number == 1){
             System.out.println("�slemler:  ");
             System.out.println("Ana hesaba(Cari Hesap) para yatirmak icin 0 tuslayin");
             System.out.println("K�sa Vadeli hesaba para yatirmak icin 1 tuslayin");
             System.out.println("Uzun Vadeli hesaba para yatirmak icin 2 tuslayin");
             System.out.println("Ozel hesaba para yatirmak icin 3 tuslayin");
             System.out.println("Cari hesaba para yatirmak icin 4 tuslayin");
             int index = scan.nextInt();
             if (AccountControl(index)){
                 SelectedAccountDeposit(index);
             }
             else{
                 System.out.println("Para yat�rmak istediginiz hesap turune ait bir hesab�n�z bulunmamaktad�r..");
             }

         }

         if (number == 2){
             System.out.println("�slemler:  ");
             System.out.println("Ana hesap(CariHesap)'tan para cekmek icin 0 tuslayin");
             System.out.println("K�sa Vadeli hesaptan para cekmek icin 1 tuslayin");
             System.out.println("Uzun Vadeli hesaptan para cekmek icin 2 tuslayin");
             System.out.println("Ozel hesaptan para cekmek icin 3 tuslayin");
             System.out.println("Cari hesaptan para cekmek icin 4 tuslayin");
             int index = scan.nextInt();

             if (AccountControl(index)){
                 SelectedAccountwithdraw(index);
             }
             else{
                 System.out.println("Para cekmek istediginiz hesap turune ait bir hesab�n�z bulunmamaktad�r..");
             }
         }

    }

    public boolean AccountControl(int index){
        return hesaplarim[index] != null ? true : false;
    }

    public void SelectedAccountwithdraw(int selectAccountIndex){
        hesaplarim[selectAccountIndex].withdraw();
    }

    public void SelectedAccountDeposit(int selectAccountIndex){
        hesaplarim[selectAccountIndex].deposit();
    }

}