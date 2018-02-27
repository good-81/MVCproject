package Model;

import Model.DAO;

import java.util.List;

public interface CompanyDao extends DAO {

    //На мой взгляд здесь не хватает функции INSERT
    long addEntity(Company entity);
    boolean updateEntity(Company entity);
    boolean deleteEntity(Company entity);

//    List<Entity> findEntityByParameter(EntitySearchType searchType, Object parameter);
    List<Company> findEntityByParameter(EntitySearchType searchType, Object parameter);
}
