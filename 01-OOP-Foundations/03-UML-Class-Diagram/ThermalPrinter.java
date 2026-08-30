
public class ThermalPrinter extends Printer{
    public ThermalPrinter(String printerId,String model){
        super(printerId,model);
    }
    @Override
    public void print(){
        setStatus(PrinterStatus.PRINTING);
        System.out.println("Thermal printer is Printing...");

        setStatus(PrinterStatus.READY);
    }
    
}
