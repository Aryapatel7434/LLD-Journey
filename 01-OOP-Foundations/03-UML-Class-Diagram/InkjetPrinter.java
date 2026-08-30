
import java.text.NumberFormat.Style;

public class InkjetPrinter extends Printer{
    public InkjetPrinter(String printerId,String model){
        super(printerId,model);
    }
    @Override
    public void print(){
        setStatus(PrinterStatus.PRINTING);

        System.out.println("Inkjet printer is printing....");

        setStatus(PrinterStatus.READY);
    }
    
}
