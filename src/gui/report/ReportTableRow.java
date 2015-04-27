package gui.report;

/**
 * Created by Adam Lee on 23/04/2015.
 */
public class ReportTableRow {

    private int saleId;
    private int empId;
    private int prodId;
    private String saleDay;
    private String saleMonth;
    private String saleYear;
    private String saleTime;
    private double saleDiscount;
    private double saleAmount;

    public ReportTableRow()
    {
        this.saleId = 0;
        this.empId = 0;
        this.prodId = 0;
        this.saleDay = "";
        this.saleMonth = "";
        this.saleYear = "";
        this.saleTime = "";
        this.saleDiscount = 0.0;
        this.saleAmount = 0.0;
    }

    public ReportTableRow(int saleIdIn, int empIdIn, int prodIdIn, String saleDayIn,String saleMonthIn,String saleYearIn, String saleTimeIn, double saleDiscountIn, double saleAmountIn)
    {
        saleId = saleIdIn;
        empId = empIdIn;
        prodId = prodIdIn;
        saleDay = saleDayIn;
        saleMonth = saleMonthIn;
        saleYear = saleYearIn;
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
    public int getProdId(){ return prodId;}
    public String getSaleDay(){return saleDay;}
    public String getSaleMonth(){ return saleMonth; }
    public String getSaleYear() { return saleYear; }
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
