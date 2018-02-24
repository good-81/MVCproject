package Model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DerbyCompanyDao implements CompanyDao {

    private final static String DB_NAME = "entities.db";
    //    private final static String TABLE_NAME = "entities1";
    private final static String TABLE_NAME = "Company2";
    private Connection connection;
    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public void setup() throws Exception {
        connection = DriverManager.getConnection("jdbc:derby:" + DB_NAME + ";" + "create=true");
        try {
//            dbAccess.update(connection, "CREATE TABLE " + TABLE_NAME + " ("
//                    + "unique_id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY(start with 1, increment by 1), "
//                    + "entityName VARCHAR(30), " +
//                    "PSRN BIGINT, " +
//                    "entityAddress VARCHAR(250))");
            dbAccess.update(connection,
                    "CREATE TABLE " + TABLE_NAME + " ("
                            + "unique_id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY(start with 1, increment by 1), "
                            + "comp_name VARCHAR(100), "
                            + "comp_name_short VARCHAR(100), "
                            + "comp_name_eng VARCHAR(100), "
                            + "type_of_business VARCHAR(100), "
                            + "OGRN VARCHAR(100), "
                            + "INN VARCHAR(100), "
                            + "KPP VARCHAR(100), "
                            + "OKVED VARCHAR(100), "
                            + "OKPO VARCHAR(100), "
                            + "date_of_incorporation VARCHAR(100), "
                            + "registrar_name VARCHAR(100), "
                            + "comp_address VARCHAR(100), "
                            + "comp_phone VARCHAR(100), "
                            + "comp_mail VARCHAR(100), "
                            + "charter_capital REAL)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void connect() throws Exception {
        connection = DriverManager.getConnection("jdbc:derby:" + DB_NAME);
    }

    @Override
    public void close() throws Exception {
        connection.close();
        try {
            DriverManager.getConnection("jdbc:derby:" + DB_NAME + ";" + "shutdown=true");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public long addEntity(Company entity) {
        try {
            long id = (dbAccess.insert(connection, "INSERT INTO " + TABLE_NAME
                            + " (comp_name, " +
                            "comp_name_short, " +
                            "comp_name_eng, " +
                            "type_of_business, " +
                            "OGRN, " +
                            "INN, " +
                            "KPP, " +
                            "OKVED, " +
                            "OKPO, " +
                            "date_of_incorporation, " +
                            "registrar_name, " +
                            "comp_address, " +
                            "comp_phone, " +
                            "comp_mail, " +
                            "charter_capital) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new ScalarHandler<BigDecimal>(),
                    entity.getComp_name(),
                    entity.getComp_name_short(),
                    entity.getComp_name_eng(),
                    entity.getType_of_business(),
                    entity.getOGRN(),
                    entity.getINN(),
                    entity.getKPP(),
                    entity.getOKVED(),
                    entity.getOKPO(),
                    entity.getDate_of_incorporation(),
                    entity.getRegistrar_name(),
                    entity.getComp_address(),
                    entity.getComp_phone(),
                    entity.getComp_mail(),
                    entity.getCharter_capital()).longValue());
            return id;
        } catch (Exception e) {
            //TODO Send message to the User
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateEntity(Company entity) {
        try {
            dbAccess.update(connection, "UPDATE " + TABLE_NAME + " SET comp_name=?, comp_address=?, comp_mail=? " +
                            "WHERE unique_id=?",
                    entity.getComp_name(), entity.getComp_address(), entity.getComp_mail(), entity.getUnique_id());
            return true;

        } catch (SQLException e) {
            //TODO Send message to the User
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Company entity) {
        try {
            dbAccess.update(connection, "DELETE FROM " + TABLE_NAME + " WHERE unique_id=?", entity.getUnique_id());
        } catch (SQLException e) {
            //TODO Send message to the User
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Company> findEntityByParameter(EntitySearchType searchType, Object parameter) {
        String whereClause = "";
        String valueClause = "";

        switch (searchType) {
            case INN:
                whereClause = "INN=?";
                valueClause = parameter.toString();
                break;
            case KPP:
                whereClause = "KPP=?";
                valueClause = parameter.toString();
                break;
            case OGRN:
                whereClause = "OGRN=?";
                valueClause = parameter.toString();
                break;
        }

        try {
            List<Company> list = dbAccess.query(connection, "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + whereClause, new BeanListHandler<>(Company.class), valueClause);
            return list;
        } catch (SQLException e) {
            //TODO Send message to the User
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
