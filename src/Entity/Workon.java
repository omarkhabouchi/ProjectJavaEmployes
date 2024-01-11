
package Entity;

import company.Tools;
import javax.swing.JTable;

public class Workon implements mainData {
    
    
    private int EmpNo ;
    private int ProjectNo ;

    public int getEmpNo() {
        return EmpNo;
    }

    public void setEmpNo(int EmpNo) {
        this.EmpNo = EmpNo;
    }

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNo) {
        this.ProjectNo = ProjectNo;
    }

    @Override
    public void add() {
        String strselect = "insert into workon values("
                + EmpNo + ","
                + ProjectNo + ")";
        boolean isadd = DB.go.runNonQuery(strselect);
        if(isadd){
            Tools.MsgBox("workon is added ");
        }
    }

    @Override
    public void update() {
        Tools.MsgBox("no");
    }

    @Override
    public void delete() {
       String delet = "delete from workon where EmpNo= " + EmpNo + "and ProjectNo=" + ProjectNo ; 
       boolean isdelt = DB.go.runNonQuery(delet);
        if(isdelt){
            Tools.MsgBox("workon is deleted ");
        }
    }

    @Override
    public String getAutoNumber() {
        Tools.MsgBox("no");
        return null;
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("workon_data" , table);
    }

    @Override
    public void getOneRows(JTable table) {
       String strselect = "select * from workon_data where"
                + "EMPLOYEE_NO=" + EmpNo
                + "and "
                + "PROJECT_NO=" + ProjectNo ;
       DB.go.fillToJTable(strselect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String name) {
        Tools.MsgBox("no");
        return null;
    }

    @Override
    public String getValueByName(String value) {
       Tools.MsgBox("no");
        return null;
    }
    
}
