package gui.report;

/**
 * Created by Adam Lee on 23/04/2015.
 */
public class ReportTableRow {

    private int saleId;
    private int empId;
    private String saleDate;
    private String saleTime;
    private double saleDiscount;
    private double saleAmount;

    public ReportTableRow()
    {
        this.saleId = 0;
        this.empId = 0;
        this.saleDate = "";
        this.saleTime = "";
        this.saleDiscount = 0.0;
        this.saleAmount = 0.0;
    }

    public ReportTableRow(int saleIdIn, int empIdIn, String saleDateIn, String saleTimeIn, double saleDiscountIn,
                          double saleAmountIn)
    {
        saleId = saleIdIn;
        empId = empIdIn;
        saleDate = saleDateIn;
        saleTime = saleTimeIn;
        saleDiscount = saleDiscountIn;
        saleAmount = saleAmountIn;
    }

    public int getSaleId(){
        return  saleId;
    }
    public int getEmpId(){
        return empId;
    }
    public String getSaleDate(){ return saleDate;}
    public String getSaleTime(){
        return saleTime;
    }
    public double getSaleDiscount(){
        return saleDiscount;
    }
    public double getSaleAmount(){
        return saleAmount;
    }
}
