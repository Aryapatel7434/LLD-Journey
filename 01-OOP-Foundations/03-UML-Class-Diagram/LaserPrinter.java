
public class LaserPrinter extends Printer implements Scannable{

    public LaserPrinter(String printerId,String model){
        super(printerId,model);//calll the parent class constructor.
    }
    @Override
    public void print(){
         setStatus(PrinterStatus.PRINTING);

         System.out.println("Laser printer is printing...");
         setStatus(PrinterStatus.READY);
    }

    @Override
    public void scan(){
        System.out.println(
            "Laser printer is scanning..."
        );
    }
    
}
