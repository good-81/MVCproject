import Model.DerbyCompanyDao;
import Model.CompanyDao;
import Model.EntityModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LawTool extends Application {

    private CompanyDao buildDao() {
        return new DerbyCompanyDao();
    }

    private EntityModel buildModel() {
        return new EntityModel(buildDao());
    }

    private Controller buildController(Stage stage) {
        return new Controller(buildModel(), stage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/law_tool_ui.fxml"));
        loader.setControllerFactory(controller -> buildController(primaryStage));

        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }



    public static void main(String[] args) throws Exception {
        launch(args);
//        Model.CompanyDao entityDao = new Model.DerbyCompanyDao();
//        entityDao.setup();
//        Model.EntityModel model = new Model.EntityModel(entityDao);
//
//        model.addNewCompany(
//                "ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"СБЕРБАНК РОССИИ\"",
//                "ПАО СБЕРБАНК",
//                "SberBank OJSC",
//                "OJSC",
//                "1027700132195",
//                "7707083893",
//                "773601001",
//                "22.08.2002",
//                "Управление Федеральной налоговой службы по г.Москве",
//                "117997, ГОРОД МОСКВА, УЛИЦА ВАВИЛОВА, д. 19",
//                67760844000F,
//                "64.19 Денежное посредничество прочее",
//                "425968",
//                "7(495)7778881",
//                "gref@sb.ru");
//
//
//        entityDao.close();
//        System.exit(0);
    }
}
