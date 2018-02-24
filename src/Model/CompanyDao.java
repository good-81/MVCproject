package Model;

import Model.DAO;

import java.util.List;

public interface CompanyDao extends DAO {
    long addEntity(Company entity);
    boolean updateEntity(Company entity);
    boolean deleteEntity(Company entity);

//    List<Entity> findEntityByParameter(EntitySearchType searchType, Object parameter);
    List<Company> findEntityByParameter(EntitySearchType searchType, Object parameter);
}
