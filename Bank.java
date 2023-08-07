import java.util.*;

class Account {
    private long acc_no;
    private String name,email;
    private float amount;
    Account(long acc_no,String name,String email,float amount)
    {
        this.acc_no = acc_no;
        this.name = name;
        this.email = email;
        this.amount = amount;
    }
    public long getAcc_no() {
        return acc_no;
    }
    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String toString()
    {
        return "Account Number : "+this.getAcc_no()+"\nName : "+this.getName()+"\nEmail : "+this.getEmail()+"\nAmount : "+this.getAmount()+"||";
    }
}

class dataBase
{
    public static List<Account> account = new ArrayList<>();
}
class Operations
{
    static Scanner sc = new Scanner(System.in);
    public void changeAccount()
    {
        int ch;
        System.out.println("=================================================================");
        System.out.println("Enter Your Choice :                                            ||");
        System.out.println("1.Change Name :                                                ||");
        System.out.println("2.Change Email Id :                                            ||");
        System.out.println("3.Change Amount :                                              ||");
        System.out.println("Enter your Choice :                                            ||");
        ch = sc.nextInt();
        System.out.println("=================================================================");
        Account acc  = findAcc();
        switch (ch)
        {
            case 1 :
                System.out.println("Enter the Name:");
                sc.nextLine();
                String name = sc.nextLine();
                acc.setName(name);
                break;
            case 2:
                System.out.println("Enter Email Id:");
                sc.nextLine();
                String mail = sc.nextLine();
                acc.setEmail(mail);
                break;
            case 3 :
                System.out.println("Enter the Amount:");
                sc.nextLine();
                float amount = sc.nextFloat();
                acc.setAmount(amount);
                break;
        }

    }
    public void showDetails(Account acc)
    {
        System.out.println("=================================================================");
        System.out.println(acc);
        System.out.println("=================================================================");
    }

    public void addAccount()
    {

        System.out.println("Enter the Account Number :                                     ||");
        long acc_no = sc.nextLong();
        System.out.println("Enter the Name :                                               ||");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter the Email Id :                                           ||");
        String email = sc.nextLine();
        System.out.println("Enter the Amount :                                             ||");
        float amount = sc.nextFloat();
        Account acc = new Account(acc_no,name,email,amount);
        dataBase.account.add(acc);
        System.out.println("Data has been Uploaded                                         ||");
        System.out.println("=================================================================");
    }

    public void showAllAccount()
    {
        System.out.println("=================================================================");
        System.out.println("All Account Details :                                          ||");
        if(dataBase.account.size() == 0)
        {
            System.out.println("No Data Found                                              ||");
        }
        for (Account acc : dataBase.account)
        {
            showDetails(acc);
        }
    }
    public void showAccount()
    {
        System.out.println("=================================================================");
        System.out.print("Enter Account Number :                                           ||");
        long acc_no = sc.nextLong();
        System.out.println("=================================================================");
        int f = 0;
        for(Account acc : dataBase.account)
        {
            if(acc.getAcc_no() == acc_no)
            {
                showDetails(acc);
                f = 1;
            }
        }
        if(f==0) {
            System.out.println("=================================================================");
            System.out.println("Account Not Found                                              ||");
            System.out.println("=================================================================");
        }
    }

    public Account findAcc()
    {
        System.out.println("=================================================================");
        System.out.print("Enter Account Number :                                          || ");
        long acc_no = sc.nextLong();
        System.out.println("=================================================================");
        for(Account acc : dataBase.account)
        {
            if(acc.getAcc_no() == acc_no)
            {
                return acc;
            }
        }
        return null;
    }
}


public class Bank
{
    public static void main(String[] args) {
        Operations d = new Operations();
        while(true) {
            System.out.println("=================================================================");
            System.out.println("Enter your choice to do Operations :-                          ||");
            System.out.println("1. Add new Account                                             ||");
            System.out.println("2. Show All Account                                            ||");
            System.out.println("3. Show Account                                                ||");
            System.out.println("4. Change Account Details                                      ||");
            System.out.println("Enter your Choice :                                            ||");
            int choice = Operations.sc.nextInt();
            System.out.println("=================================================================");
            switch (choice) {
                case 1:
                    d.addAccount();
                    break;
                case 2:
                    d.showAllAccount();
                    break;
                case 3:
                    d.showAccount();
                    break;
                case 4:
                    d.changeAccount();
                    break;
            }
        }
    }
}
