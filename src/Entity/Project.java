
package Entity;

import company.Tools;
import javax.swing.JTable;
import javax.tools.Tool;

public class Project implements mainData {
    
 private int ProjectNo ;
 private String ProjectName;
 private String Location;
 private int deptno;

    public int getProjectNo() {
        return ProjectNo;
    }

    public void setProjectNo(int ProjectNO) {
        this.ProjectNo = ProjectNo;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public void add() {
        String strselect ="insert into project values(" 
                + ProjectNo + ","
                + "'" + ProjectName + "',"
                + "'" + Location + "',"
                + deptno + ")";
        boolean isadd = DB.go.runNonQuery(strselect);
        if(isadd){
            Tools.MsgBox("Project Is Added :");
        }
    }

    @Override
    public void update() {
        String strUpdate = "update project set " 
                + "ProjectName='" + ProjectName + "',"
                + "Location='" + Location + "',"
                + "deptno=" + deptno 
                + " where ProjectNo=" + ProjectNo ; 
        boolean isupdate = DB.go.runNonQuery(strUpdate);
        if(isupdate){
            Tools.MsgBox("project is updated ");
        }
    }

    @Override
    public void delete() {
        String delet = "delete from project " 
                + " where ProjectNo=" + ProjectNo  ;
        boolean isdelete = DB.go.runNonQuery(delet);
        if(isdelete){
            Tools.MsgBox("project is deleted ");
        }
    }

    @Override
    public String getAutoNumber() {
        return DB.go.getAutoNumber("project", "ProjectNo");
    }

    @Override
    public void getAllRows(JTable table) {
        DB.go.fillToJTable("project_data" , table);
    }

    @Override
    public void getOneRows(JTable table) {
       String strselect = "select * from project_data"
       + " where PROJECT_NO=" + ProjectNo ;
       DB.go.fillToJTable(strselect, table);
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        DB.go.fillToJTable(statement, table);
    }

    @Override
    public String getNameByValue(String value) {
         String strselect = "select ProjectName from project"
                 + " where ProjectNo=" + value ;
         String strname = DB.go.getTableData(strselect).Items[0][0].toString();
         return strname ;
    }

    @Override
    public String getValueByName(String name) {
        String strselect = "select ProjectNo from project"
                 + " where ProjectName='" + name + "'" ;
        String strval = DB.go.getTableData(strselect).Items[0][0].toString();
         return strval ;
    }
 
    
}
