

public class Main {
    public static void main(String[]args){
        Printer laser=new LaserPrinter("P101","HP LaserJet");

        Printer inkjet=new InkjetPrinter("P102", "Canon Inkjet");

        Printer thermal=new ThermalPrinter("P103","Zebra Thermal");

        Department IT=new Department("D101","IT");

        IT.assignPrinter(laser);
        IT.assignPrinter(inkjet);
        IT.assignPrinter(thermal);


        laser.print();
        inkjet.print();
        thermal.print();

        if(laser instanceof Scannable scannable){
            scannable.scan();
        }

        System.out.println("Department: "+IT.getName());

        System.out.println("Total printers: "+IT.getPrinters().size());
    }
    
}
