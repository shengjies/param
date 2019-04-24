package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.math.BigInteger;
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
    private TextArea backMsg;

    @FXML
    private TextField wifname;

    @FXML
    private TextField wifpwd;

    @FXML
    private TextArea wifmsg;



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
     * 设置WiFi名称
     * @param actionEvent
     */
    @FXML
    public void onBtnWifiName(ActionEvent actionEvent){
        if("".equals(host.getText())|| "".equals(port.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("请填写IP或者端口");
            alert.showAndWait();
        }else{
            if("".equals(wifname.getText().trim())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("请填写Wifi名称");
                alert.showAndWait();
                return;
            }
            try {
                int p = Integer.parseInt(port.getText().trim());
                s=new Socket(host.getText().trim(),p);
                pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                String info = "553A0983"+Integer.toHexString(Integer.parseInt(wifname.getText().trim()))+"CS";
                pw.println(info);
                pw.flush();
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String str=br.readLine();
                StringBuffer sb = new StringBuffer();
                sb.append("发送内容为:");
                sb.append(info);
                sb.append("\n");
                sb.append("接收内容为:");
                sb.append(str);
                wifmsg.setText(sb.toString());
            }catch (Exception e) {
                wifmsg.setText(getStackTrace(e));
            }
            try {
                pw.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 设置WiFi密码
     * @param actionEvent
     */
    @FXML
    public void onBtnWifiPwd(ActionEvent actionEvent){
        if("".equals(host.getText())|| "".equals(port.getText())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("请填写IP或者端口");
            alert.showAndWait();
        }else{
            if("".equals(wifpwd.getText().trim())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setContentText("请填写Wifi密码");
                alert.showAndWait();
                return;
            }
            try {
                int p = Integer.parseInt(port.getText().trim());
                s=new Socket(host.getText().trim(),p);
                pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                String info = "553A0984"+Integer.toHexString(Integer.parseInt(wifpwd.getText().trim()))+"CS";
                pw.println(info);
                pw.flush();
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                String str=br.readLine();
                StringBuffer sb = new StringBuffer();
                sb.append("发送内容为:");
                sb.append(info);
                sb.append("\n");
                sb.append("接收内容为:");
                sb.append(str);
                wifmsg.setText(sb.toString());
            }catch (Exception e) {
                wifmsg.setText(getStackTrace(e));
            }
            try {
                pw.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;

        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString().trim();
    }

}
