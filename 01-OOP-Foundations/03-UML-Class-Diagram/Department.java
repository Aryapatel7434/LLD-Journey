
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private static final Object Printer = null;
    private final String departmentId;
    private final String name;

    private final List<Printer>Printers=new ArrayList<>();

    public Department(String departmentId,String name){
        this.departmentId=departmentId;
        this.name=name;
    }
    public void assignPrinter(Printer printer){
        if(printer==null){
            throw new IllegalArgumentException(
                "Printer cannot be null"
            );
        }
        Printers.add(printer);
    }
    public void removePrinter(Printer printer){
        Printers.remove(Printer);
    }
    public List<Printer>getPrinters(){
        return Collections.unmodifiableList(Printers);
    }
    public String getDepartmentId(){
        return departmentId;
    }
    public String getName(){
        return name;
    }

}
