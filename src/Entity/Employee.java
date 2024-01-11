
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Employee implements mainData{
  
    private int EmpNO;
    private String EmpName;
    private String Address;
    private double Salary;
    private String HiringDate;
    private String BirthDate;
    private int deptno;

    public int getEmpNO() {
        return EmpNO;
    }

    public void setEmpNO(int EmpNO) {
        this.EmpNO = EmpNO;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String HiringDate) {
        this.HiringDate = HiringDate;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public void add() {
        String strinsert = "insert into employee values("
                + EmpNO + "," 
                + "'" + EmpName + "'," 
                + "'" + Address + "',"
                + Salary  +  ","
                + "'" + HiringDate + "',"
                + "'" + BirthDate + "',"
                + deptno + ")";
        boolean isAdd = DB.go.runNonQuery(strinsert);
        if(isAdd){
        Tools.MsgBox("Employee Is Add");
        }
    }

    @Override
    public void update() {
        String Update = "update employee set "
                + "EmpName='" + EmpName + "'," 
                + "Address='" + Address + "',"
                +"Salary=" + Salary  +  ","
                + "HiringDate='" + HiringDate + "',"
                + "BirthDate='" + BirthDate + "',"
                + "deptno=" + deptno  
                + " where EmpNO=" + EmpNO;
        
        boolean isUpdate = DB.go.runNonQuery(Update);
        if(isUpdate){
            Tools.MsgBox("Employee Is Updated");
        }
    }

    @Override
    public void delete() {
        String Delete = "delete from employee" 
                + " where EmpNO=" +EmpNO ;
        boolean isdelete = DB.go.runNonQuery(Delete);
        if(isdelete){
            Tools.MsgBox("Employee Is Deleted");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("employee", "EmpNO");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("employee_data", table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strselect = "select * from employee_data" + " where Number=" + EmpNO;
        DB.go.fillToJTable(strselect , table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
        String strvalue = "select EmpName from employee "
                + " where EmpNO="  + value ;
        String strName = DB.go.getTableData(strvalue).Items[0][0].toString();
        return strName;
    }

    @Override
    public String getValueByName(String name) {
        String strName = "select EmpNO from employee"
                + " where EmpName='" + name + "'" ;
        String strVal = DB.go.getTableData(strName).Items[0][0].toString();
        return strVal;
    }
    
}
