package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class loginFormController {

    public List<User> userList= new ArrayList<>();
    @FXML

    //**TEXT FIELDS**//
    //*log in section*//
    public TextField userNameLField;
    public TextField passwordLField;

    //*sign up section*//
    public TextField fullNameSField;
    public TextField userNameSField;
    public TextField passwordSField;

    //**BUTTONS**//
    public Button signUpBtn;
    public Button logInBtn;
    public Button addAccountBtn;
    public VBox mainVbox;
    public VBox signUpVBox;

    //**Labels**//
    public Label errorLbl;
    public Label errorLbl1;
    public Label signUpErrLbl;
    public Label messageLbl;
    public Text messageText;

    public Label test;

    //**INITIALIZE**//




    @FXML
    public void  onLoginBtnClick() throws IOException {
        String userNAme= userNameLField.getText();
        String password= passwordLField.getText();
        setErrorLblsAsDefoult();
        clearLogInFields();

       if(Objects.equals(userNAme, User.DEFAULT_USER.userName) &&
           Objects.equals(password, User.DEFAULT_USER.password)){
            messageBoxShow("Login Successfully ^ ^","login Successfully!");

       }else { errorLbl.setTextFill(Color.RED);
           errorLbl.setText("the userName or");
           errorLbl1.setVisible(true);}
    }

    @FXML
    protected void onSignUpBtnClick(){

        if(!signUpVBox.isVisible()){signUpVBox.setVisible(true);}

    }

    public void onAddAccountBtnClick() throws IOException {
        String fullName= fullNameSField.getText();
        String userNAme= userNameSField.getText();
        String password= passwordSField.getText();
        User newUser= new User(fullName,userNAme,password);
        if(!fullName.isEmpty()|| !userNAme.isEmpty()|| !password.isEmpty()){
            for (User user:userList){
                if(!Objects.equals(userNAme,user.userName) &&
                   !Objects.equals(fullName,user.fullName)&&
                   !Objects.equals(password,user.password)){
                    userList.add(newUser);
                    signUpErrLbl.setText("");
                    clearSignUpFeilds();
                    messageText.setText("text fffffffff");
                    messageBoxShow("Account Added Successfully ^ ^","Accunt Added");

                    signUpVBox.setVisible(false);
                }else {signUpErrLbl.setText("All fields are required");}
        }
        }else { signUpErrLbl.setText("All fields are required");}




    }

    public void setErrorLblsAsDefoult(){
        errorLbl.setTextFill(Color.BLACK);
        errorLbl.setText("or");
        errorLbl1.setVisible(false);

    }

    public void clearSignUpFeilds(){
        fullNameSField.setText("");
        userNameSField.setText("");
        passwordSField.setText("");
    }

    public void clearLogInFields(){
        userNameLField.setText("");
        passwordLField.setText("");
    }
    
    public void messageBoxShow(String text,String title) throws IOException {


        Parent root1 = (Parent) FXMLLoader.load(this.getClass().getResource("new.fxml"));
       // FXMLLoader fxmlLoader = new FXMLLoader(loginFormApplication.class.getResource("messageBox.fxml"));
        Scene scene = new Scene(root1);
        Stage messageBoxStag= new Stage();
        messageBoxStag.setTitle(title);
        messageBoxStag.resizableProperty().setValue(false);
        messageBoxStag.setScene(scene);
        messageBoxStag.show();

        try{ test.setText("test!");}catch (Exception e){System.out.println("errrrrrror");}
    }
}