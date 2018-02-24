package Model;

public class Entity {

    private long unique_id;
    private String entityName;
    private long PSRN;
    private String entityAddress;

    public long getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(long unique_id) {
        this.unique_id = unique_id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public long getPSRN() {
        return PSRN;
    }

    public void setPSRN(long PSRN) {
        this.PSRN = PSRN;
    }

    public String getEntityAddress() {
        return entityAddress;
    }

    public void setEntityAddress(String entityAddress) {
        this.entityAddress = entityAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
              sb.append("unique id is: " + unique_id + ", ")
                .append("name is: " + entityName + ", ")
                .append("address is: " + entityAddress + ", ")
                .append("psrn is: " + getPSRN());
        return sb.toString();
    }
}
