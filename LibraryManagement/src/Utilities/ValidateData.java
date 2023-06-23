/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class ValidateData {
    //Hàm kiểm tra chuỗi rỗng
    public Boolean isEmptyString(String ...args){
        for (String arg : args) {
            if(arg.trim().equals("")){
                return true;
            }
        }
        return false;
    }
    
    //Hàm kiểm tra số điện thoại hợp lệ
    public Boolean isPhoneNumber(String sdt){
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(sdt);
        if(m.matches()){
            return true;
        }
        return false;
    }
    
    //Hàm kiểm tra số điện thoại hợp lệ
    public Boolean isEmail(String sdt){
        String reg = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(sdt);
        if(m.matches()){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số điện thoai:");
            String nhạp = sc.nextLine();
            ValidateData d = new ValidateData();
            d.isPhoneNumber(nhạp);
        }
    }
}
