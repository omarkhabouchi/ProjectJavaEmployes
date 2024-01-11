
package Entity;

import company.Tools;
import javax.swing.JTable;


public class Employee_Phones implements mainData {
    
    private int EmpNo ;
    private String Phone; 

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public void add() {
        
        String strinsert = "insert into employee_phones values("
                + EmpNo + "," + "'" + Phone + "')";
        boolean isadd = DB.go.runNonQuery(strinsert);
        if(isadd){
            Tools.MsgBox("Employee_phone Is Added ");
        }
               
    }

    @Override
    public void update() {
        
       
            Tools.MsgBox("Updat Method in  Employee_phone in class Not Working");
        
    }

    @Override
    public void delete() {
                String delete = "delete from employee_phones "
                + " where " 
                + " empNo=" +  EmpNo 
                + " and phone='" + Phone + "'" ;
                boolean isDelete = DB.go.runNonQuery(delete);
        if(isDelete){
            Tools.MsgBox("Employee_phone Is deleted ");
        }
    }

    public void deletByEmp(){
         String strdelete = "delete from employee_phones" 
                 + " where EmpNo=" + EmpNo ;
           boolean isDele = DB.go.runNonQuery(strdelete);
           
        if(isDele){
            Tools.MsgBox("Employee_phone Is delete ");
        }
    
    }
    
    @Override
    public String getAutoNumber() {
        Tools.MsgBox("getAutoNumber Method in  Employee_phone in class Not Working");
           return "";
    }

    @Override
    public void getAllRows(JTable table) {
        String select = "select phone from employee_phones" 
                + " where EmpNo=" + EmpNo ;
        DB.go.fillToJTable(select, table);
        
    }

    @Override
    public void getOneRows(JTable table) {
        Tools.MsgBox("getOneRows Method in  Employee_phone in class Not Working");
        
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
       Tools.MsgBox("getCustomRows Method in  Employee_phone in class Not Working");
        
    }

    @Override
    public String getNameByValue(String name) {
       Tools.MsgBox("getNameByValue Method in  Employee_phone in class Not Working");
         return "";
    }

    @Override
    public String getValueByName(String value) {
         Tools.MsgBox("getValueByName Method in  Employee_phone in class Not Working");
            return "";
    }
    
    public String getEmpNoByPhone(String requesPhone){
    
        String strSelect = "select EmpNo from employee_phones" 
                + " where phone='" + requesPhone + "'" ;
        
        Object row[][] = DB.go.getTableData(strSelect).Items ;
       String strEmpNo = "" ;
        if(row.length > 0){
         //String strEmpNo = (String) DB.go.getTableData(strSelect).Items[0][0];
         strEmpNo =(String) row[0][0];
        }
        else{
            strEmpNo = "0";
        }
        return strEmpNo ;
    }
    
}
