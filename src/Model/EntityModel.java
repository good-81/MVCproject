package Model;

import java.util.List;

public class EntityModel {

    private CompanyDao companyDao;

    public EntityModel(CompanyDao companyDao) {
        this.companyDao = companyDao;
        try {
            companyDao.setup();
        } catch (Exception e) {

        }
    }

    public long addNewEntity(Entity entity) {
        return 0;
    }

    public long addNewEntity(String entityName, long PSRN, String entityAddress) {
        Entity entity = new Entity();
        entity.setEntityName(entityName);
        entity.setPSRN(PSRN);
        entity.setEntityAddress(entityAddress);
        return 0;
    }

    public long addNewCompany(
                String comp_name,
                String comp_name_short,
                String comp_name_eng,
                String type_of_business,
                String OGRN,
                String INN,
                String KPP,
                String date_of_incorporation,
                String registrar_name,
                String comp_address,
                float charter_capital,
                String OKVED,
                String OKPO,
                String comp_phone,
                String comp_mail) {


        Company company = new Company();
        company.setCharter_capital(charter_capital);
        company.setComp_address(comp_address);
        company.setComp_mail(comp_mail);
        company.setComp_name(comp_name);
        company.setComp_name_eng(comp_name_eng);
        company.setComp_name_short(comp_name_short);
        company.setComp_phone(comp_phone);
        company.setDate_of_incorporation(date_of_incorporation);
        company.setINN(INN);
        company.setKPP(KPP);
        company.setOGRN(OGRN);
        company.setOKPO(OKPO);
        company.setOKVED(OKVED);
        company.setType_of_business(type_of_business);
        company.setRegistrar_name(registrar_name);

        return companyDao.addEntity(company);
    }



    public boolean deleteEntity(Company entity) {
        boolean isDeleted = companyDao.deleteEntity(entity);
        return isDeleted;
    }

    public boolean updateEntity(Company entity) {
        return companyDao.updateEntity(entity);
    }


    //    public List<Entity> search (EntitySearchType searchType, Object parameter) {
//        return companyDao.findEntityByParameter(searchType, parameter);
//    }
    public List<Company> search(EntitySearchType searchType, Object parameter) {
        return companyDao.findEntityByParameter(searchType, parameter);
    }

    public void closeDB() {
        try {
            companyDao.close();
        } catch (Exception e) {

        }
    }
}
