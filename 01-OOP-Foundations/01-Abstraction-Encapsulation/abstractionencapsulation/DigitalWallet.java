
import java.math.BigDecimal;

public class DigitalWallet {
        public static void main(String[]args){
            //left side wallet and right side persoalwallet why because your program against abstraction so we onl
            //need to know abstract methos Not implementation.
      
            Wallet personal = new PersonalWallet("PW101", "Arya",new BigDecimal("10000"));
                                
            Wallet business = new PersonalWallet("BW101","Arya Business",new BigDecimal("10000"));

            System.out.println("Initial Balance:"+personal.getBalance());

            personal.deposit(new BigDecimal("5000"));

            System.out.println("After Deposite:"+personal.getBalance());

            personal.withdraw(new BigDecimal("3000"));

            System.out.println("After withdrawal:"+personal.getBalance());


            System.out.println("Intial Balance:"+business.getBalance());

          business.withdraw(new BigDecimal("9000"));

          System.out.println("After withdrawl:"+business.getBalance());

          try{
            business.withdraw(new BigDecimal("5500"));
          }
          catch(IllegalStateException e){
            System.out.println("Rejected:"+e.getMessage());
          }

        }    
}
