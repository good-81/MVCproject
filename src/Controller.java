import Model.Company;
import Model.Entity;
import Model.EntityModel;
import Model.EntitySearchType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class Controller {

    @FXML
    private ChoiceBox choice_box;

    @FXML
    private TextField parameter_txt;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField address_txt;

    @FXML
    private TextField psrn_txt;

    @FXML
    private TextField name_txt_upd;

    @FXML
    private TextField address_txt_upd;

    @FXML
    private TextField mail_txt_upd;

    @FXML
//    private ListView<Entity> entity_list_view;
    private ListView<Company> entity_list_view;

    private EntityModel entityModel;
    private Company selectedItem;

    public Controller(EntityModel entityModel, Stage stage) {
        this.entityModel = entityModel;
        stage.setOnCloseRequest(event -> entityModel.closeDB());
    }


    public void initialize() {
        choice_box.getItems().setAll(EntitySearchType.values());
        choice_box.getSelectionModel().selectFirst();
    }

    public void onItemSelected(MouseEvent mouseEvent) {
        selectedItem = entity_list_view.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            name_txt_upd.setText(selectedItem.getComp_name());
            address_txt_upd.setText(selectedItem.getComp_address());
            mail_txt_upd.setText(selectedItem.getComp_mail());
        }
    }

    public void onSearch(MouseEvent mouseEvent) {
        String parameter = parameter_txt.getText();

        List<Company> list = entityModel.search((EntitySearchType)choice_box.getValue(), parameter);
        entity_list_view.getItems().setAll(list);
    }

    public void onAddEntity(MouseEvent mouseEvent) {
        Entity entity = new Entity();
        entity.setEntityName(name_txt.getText());
        entity.setPSRN(Integer.valueOf(psrn_txt.getText()));
        entity.setEntityAddress(address_txt.getText());

        entityModel.addNewEntity(entity);
    }

    public void onDeleteEntity(MouseEvent mouseEvent) {
        boolean isDeleted = false;
        if (selectedItem != null)
            isDeleted = entityModel.deleteEntity(selectedItem);
        if (isDeleted) {
            //TODO update listview
        }
    }

    public void onUpdateEntity(MouseEvent mouseEvent) {
        boolean isUpdated = false;
        if (selectedItem != null){
            selectedItem.setComp_name(name_txt_upd.getText());
            selectedItem.setComp_address(address_txt_upd.getText());
            selectedItem.setComp_mail(mail_txt_upd.getText());
            isUpdated = entityModel.updateEntity(selectedItem);
        }
        if (isUpdated) {
            //TODO update listview
            name_txt_upd.setText("");
            address_txt_upd.setText("");
            mail_txt_upd.setText("");
        }
    }
}
