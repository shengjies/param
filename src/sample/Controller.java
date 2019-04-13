package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Controller {
    private static PrintWriter pw=null;
    private static Socket s;
    private static BufferedReader br=null;
    @FXML
    private TextField host;

    @FXML
    private TextField port;

    @FXML
    private TextField code;

    @FXML
    private Label msg;

    @FXML
    private TextArea backMsg;

    @FXML
    public void  onBtnClick(ActionEvent actionEvent){
        if("".equals(host.getText())|| "".equals(port.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("请填写IP或者端口");
            alert.showAndWait();
        }else{
            try {
                int p = Integer.parseInt(port.getText().trim());
                s=new Socket(host.getText().trim(),p);
                pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                String info = "553A0986"+code.getText().trim()+"CS";
                pw.println(info);
                pw.flush();
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String string=br.readLine();
                backMsg.setText(string);
            }catch (Exception e) {
                backMsg.setText(getStackTrace(e));
            }
            try {
                pw.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }
    public  String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try
        {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally
        {
            pw.close();
        }
    }
    /**
     * 发送数据
     * @param actionEvent
     */
    @FXML
    public void onBtnClien(ActionEvent actionEvent){

    }
}
