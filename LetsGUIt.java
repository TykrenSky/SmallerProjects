import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.*;

public class LetsGUIt extends Application {
   public static void main(String[] args) {
      launch(args);
   }
   
   int x = 0;
   String f = "";
   
   public void start(Stage primaryStage) {
      Button hi = new Button("Sign Up");
      HBox btn = new HBox();
      btn.setAlignment(Pos.BOTTOM_RIGHT);
      btn.getChildren().add(hi);
      Text display = new Text();
      TextField userTextField = new TextField();
      PasswordField passField = new PasswordField();
      hi.setOnAction(e -> {
         if (x == 0) { 
            display.setText("You're password is insecure");
            f = passField.getCharacters().toString();
            hi.setText("NO ITS NOT!!");
            x = 1;
         } else {
            display.setText("Yes it is, its just " + f);
         }
      });
      userTextField.setOnAction(hi.getOnAction());
      userTextField.setPromptText("Type anything here i dont care");
      userTextField.setOnMouseEntered(e -> display.setText("This is username"));
      userTextField.setOnMouseExited(e -> display.setText(""));
      passField.setOnAction(hi.getOnAction());
      passField.setPromptText("Literally doesnt matter just pick something");
      passField.setOnMouseEntered(e -> display.setText("This is password"));
      passField.setOnMouseExited(e -> display.setText(""));
      
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(15));
      grid.add(new Text("Sign In"), 0, 0);
      grid.add(new Text("User: "), 0, 1);
      grid.add(userTextField, 1, 1);
      grid.add(passField, 1, 2);
      grid.add(new Text("Password: "), 0, 2);
      grid.add(btn, 1, 3);
      grid.add(display, 1, 4);
      
      VBox sidebar = sideGen(display);
      
      VBox left = new VBox();
      left.setAlignment(Pos.TOP_LEFT);
      
      
      TextArea tester = new TextArea();
      tester.setPrefRowCount(5);
      tester.setPrefColumnCount(20);
      
      Button submit = new Button("Submit");
      submit.setOnAction(e -> {
         String text = tester.getText();
         tester.appendText("\n ----------------- \n");
         tester.appendText(text);
      });
      
      left.getChildren().addAll(tester, submit);
      
      BorderPane main = new BorderPane();
      main.setRight(sidebar);
      main.setCenter(grid);
      main.setLeft(left);
      
      Scene scene = new Scene(main, 700, 350);
      
      primaryStage.setTitle("My GUI!");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   
   private VBox sideGen(Text display) {
      VBox sidebar = new VBox();
      sidebar.setPadding(new Insets(40, 10, 10, 10));
      sidebar.setSpacing(10);
      Button btn1 = new Button("Im the first choice");
      Button btn2 = new Button("Im the worst choice");
      btn1.setOnAction(e -> {
         display.setText("You hit the first button!");
      });
      btn2.setOnAction(e -> {
         display.setText("You hit the worst button...");
      });
      
      sidebar.getChildren().add(btn1);
      sidebar.getChildren().add(btn2);
      sidebar.setAlignment(Pos.TOP_RIGHT);
      return sidebar;
   }
}