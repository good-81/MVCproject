package Model;

import java.util.Date;

public class Company {
    private long unique_id;
    private String type_of_business;
    private String comp_name;
    private String comp_name_short;
    private String comp_name_eng;
    private String OGRN;
    private String INN;
    private String KPP;
    private String date_of_incorporation;
    private String registrar_name;
    private String comp_address;
    private float charter_capital;
    private String OKVED;
    private String OKPO;
    private String comp_phone;
    private String comp_mail;

    public long getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(long unique_id) {
        this.unique_id = unique_id;
    }

    public String getType_of_business() {
        return type_of_business;
    }

    public void setType_of_business(String type_of_business) {
        this.type_of_business = type_of_business;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getComp_name_short() {
        return comp_name_short;
    }

    public void setComp_name_short(String comp_name_short) {
        this.comp_name_short = comp_name_short;
    }

    public String getComp_name_eng() {
        return comp_name_eng;
    }

    public void setComp_name_eng(String comp_name_eng) {
        this.comp_name_eng = comp_name_eng;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getKPP() {
        return KPP;
    }

    public void setKPP(String KPP) {
        this.KPP = KPP;
    }

    public String getDate_of_incorporation() {
        return date_of_incorporation;
    }

    public void setDate_of_incorporation(String date_of_incorporation) {
        this.date_of_incorporation = date_of_incorporation;
    }

    public String getRegistrar_name() {
        return registrar_name;
    }

    public void setRegistrar_name(String registrar_name) {
        this.registrar_name = registrar_name;
    }

    public String getComp_address() {
        return comp_address;
    }

    public void setComp_address(String comp_address) {
        this.comp_address = comp_address;
    }

    public float getCharter_capital() {
        return charter_capital;
    }

    public void setCharter_capital(float charter_capital) {
        this.charter_capital = charter_capital;
    }

    public String getOKVED() {
        return OKVED;
    }

    public void setOKVED(String OKVED) {
        this.OKVED = OKVED;
    }

    public String getOKPO() {
        return OKPO;
    }

    public void setOKPO(String OKPO) {
        this.OKPO = OKPO;
    }

    public String getComp_phone() {
        return comp_phone;
    }

    public void setComp_phone(String comp_phone) {
        this.comp_phone = comp_phone;
    }

    public String getComp_mail() {
        return comp_mail;
    }

    public void setComp_mail(String comp_mail) {
        this.comp_mail = comp_mail;
    }

    @Override
    public String toString() {
        return "Company{" +
                "unique_id=" + unique_id +
                ", type_of_business='" + type_of_business + '\'' +
                ", comp_name='" + comp_name + '\'' +
                ", comp_name_short='" + comp_name_short + '\'' +
                ", comp_name_eng='" + comp_name_eng + '\'' +
                ", OGRN=" + OGRN +
                ", INN=" + INN +
                ", KPP=" + KPP +
                ", date_of_incorporation=" + date_of_incorporation +
                ", registrar_name='" + registrar_name + '\'' +
                ", comp_address='" + comp_address + '\'' +
                ", charter_capital=" + charter_capital +
                ", OKVED='" + OKVED + '\'' +
                ", OKPO=" + OKPO +
                ", comp_phone='" + comp_phone + '\'' +
                ", comp_mail='" + comp_mail + '\'' +
                '}';
    }
}
