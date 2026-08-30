
public abstract class Printer {

    private final String printerId;
    private final String model;
    private PrinterStatus status;//emcapsulation

    public Printer(String printerId,String model){
        if(printerId==null || printerId.isBlank()){
            throw new IllegalArgumentException(
                "Printer ID cannot be empty"
            );
        }
        if(model==null || model.isBlank()){
            throw new IllegalArgumentException(
                "Model cannot be empty"
            );
        }
        this.printerId=printerId;
        this.model=model;
        this.status=PrinterStatus.READY;
    }
    public abstract void print();

    public String getPrinterId(){
        return printerId;
    }
    public String getModel(){
        return model;
    }
    public PrinterStatus getStatus(){
        return status;
    }
    protected void setStatus(PrinterStatus status){
        this.status=status;
    }
    
}
