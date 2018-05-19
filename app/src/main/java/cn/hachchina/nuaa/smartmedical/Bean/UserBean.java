package cn.hachchina.nuaa.smartmedical.Bean;

import java.util.List;

public class UserBean {
    private String UserName;//用户名
    private boolean isset=false;

    public String getGuanxi() {
        return Guanxi;
    }

    public void setGuanxi(String guanxi) {
        Guanxi = guanxi;
    }

    private String Guanxi;//用户名

    public String getDizhi() {
        return Dizhi;
    }

    public void setDizhi(String dizhi) {
        Dizhi = dizhi;
    }

    private String Dizhi;//用户名
    private String EmergencyContact_Numer;//紧急联系人电话号码
    private String EmergencyContact_Name;//紧急联系人姓名
    private String Default_EmergencyContact_Number="15651808915";//默认第一紧急联系方式为120
    private List<String> Drug_Allergy;//过敏药物
    private List<String> MedicalHistiry;//病史



    public UserBean(String userName, String emergencyContact_Numer, String emergencyContact_Name, List<String> drug_Allergy, List<String> medicalHistiry) {
        UserName = userName;
        EmergencyContact_Numer = emergencyContact_Numer;
        EmergencyContact_Name = emergencyContact_Name;
        Default_EmergencyContact_Number = "15651808915";
        Drug_Allergy = drug_Allergy;
        MedicalHistiry = medicalHistiry;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmergencyContact_Numer() {
        return EmergencyContact_Numer;
    }

    public boolean isIsset() {
        return isset;
    }

    public void setIsset(boolean isset) {
        this.isset = isset;
    }

    public void setEmergencyContact_Numer(String emergencyContact_Numer) {
        EmergencyContact_Numer = emergencyContact_Numer;
        isset=true;
    }

    public String getEmergencyContact_Name() {
        return EmergencyContact_Name;
    }

    public void setEmergencyContact_Name(String emergencyContact_Name) {
        EmergencyContact_Name = emergencyContact_Name;
    }

    public String getDefault_EmergencyContact_Number() {
        return Default_EmergencyContact_Number;
    }

    public void setDefault_EmergencyContact_Number(String default_EmergencyContact_Number) {
        Default_EmergencyContact_Number = default_EmergencyContact_Number;
    }

    public List<String> getDrug_Allergy() {
        return Drug_Allergy;
    }

    public void setDrug_Allergy(List<String> drug_Allergy) {
        Drug_Allergy = drug_Allergy;
    }

    public List<String> getMedicalHistiry() {
        return MedicalHistiry;
    }

    public void setMedicalHistiry(List<String> medicalHistiry) {
        MedicalHistiry = medicalHistiry;
    }

    public UserBean() {
        Default_EmergencyContact_Number = "15651808915";
    }
}
