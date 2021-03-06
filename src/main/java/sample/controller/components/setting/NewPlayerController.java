package sample.controller.components.setting;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTimePicker;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Window;
import sample.controller.components.bar.TitleSectionBarMinController;
import sample.model.Player;

import javax.annotation.PostConstruct;

import static sample.controller.components.dashboard.DashboardController.initButtonInfos;

@ViewController(value = "/view/components/setting/PlayerCreation.fxml", title = "Nouveau Match")
public class NewPlayerController extends TitleSectionBarMinController {

    public static final String CONTENT_PANE = "ContentNewPlayer";
    private static final String PREFIX = "( ";
    private static final String POSTFIX = " )";

    @FXMLViewFlowContext
    private ViewFlowContext viewFlowContext;
    @FXML
    private StackPane rootPlayerCreation;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTimePicker timePicker;
    @FXML
    @ViewNode
    private JFXButton buttonSave;
    @FXML
    @ViewNode
    private JFXButton buttonCancel;
    @ViewNode
    private Label labelTitleSection;
    @FXML
    private JFXButton buttonPopupInfoSection2;
    @FXML
    private JFXDialog dialogNewPlayer;
    @FXML
    private JFXButton buttonAcceptDialogNewPlayer;

    private FlowHandler flowHandler;

    private ObservableList<Player> observableListPlayersTeam1;
    private ObservableList<Player> observableListPlayersTeam2;

    @PostConstruct
    public void init() throws FlowException {
        viewFlowContext.register(CONTENT_PANE, rootPlayerCreation);
        labelTitleSection.setText("Création d'un joueur");
        initButtonInfo();
        initButtonInfos(rootPlayerCreation, dialogNewPlayer, buttonPopupInfoSection2, viewFlowContext, CONTENT_PANE, buttonAcceptDialogNewPlayer);
//        buttonPopupInfoSection2.setOnAction(action -> {
//            dialogNewPlayer.setTransitionType(JFXDialog.DialogTransition.CENTER);
//            dialogNewPlayer.show((StackPane) viewFlowContext.getRegisteredObject(CONTENT_PANE));
//        });
//        buttonAcceptDialogNewPlayer.setOnAction(action -> dialogNewPlayer.close());

        buttonSave.setOnAction(action -> hideWindow(buttonSave));
        buttonCancel.setOnAction(action -> hideWindow(buttonCancel));
    }

    private void hideWindow(JFXButton button) {
        Window window = buttonCancel.getScene().getWindow();
        window.hide();
    }
}

