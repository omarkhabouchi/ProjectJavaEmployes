
package Entity;

import company.Tools;
import javax.swing.JTable;

public class department  implements mainData {
   
    private int deptno;
    private String DeptName;
    private String Location;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public void add() {
        String insert = "insert into department values("
                 + deptno + "," 
                 + "'" + DeptName + "'," 
                 + "'" + Location + "')" ;
               
        boolean isAdd = DB.go.runNonQuery(insert);
          if(isAdd){
              Tools.MsgBox("department is Added");
          }         
    }

    @Override
    public void update() {
        String strupdate = " update department set "
                +"DeptName='" +DeptName+"',"
                +"Location='" +Location+"' "
                + "where deptno=" + deptno;
        
        boolean isUpdate = DB.go.runNonQuery(strupdate);
        if(isUpdate)
        {
            Tools.MsgBox("department is updated");
        }
    }

    @Override
    public void delete() {
        String strdelete = "delete from department" 
                +" where deptno=" + deptno;
        
        boolean isDelet = DB.go.runNonQuery(strdelete);
         if(isDelet)
         {
             Tools.MsgBox("department is deleted");
         }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("department", "deptno");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("department_data", table);
    }

    @Override
    public void getOneRows(JTable table) {
        String strselect = "select * from department_data"+ " where department_no=" +deptno;
        
        DB.go.fillToJTable(strselect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
        String strselect = "select DeptName from department "
                +" where deptno=" + value ;
         String strName = (String)DB.go.getTableData(strselect).Items[0][0];
         return strName;
    }

    @Override
    public String getValueByName(String name ) {
        String strSelect = "select deptno from department" 
                + " where DeptName='" + name +"'";
        String strval = (String)DB.go.getTableData(strSelect).Items[0][0];
        return strval;
    }
    
    


}
