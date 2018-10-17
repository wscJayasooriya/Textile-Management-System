/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.LOOPER_gentsWear.common;

import javax.swing.JTextField;

/**
 *
 * @author Sandun_CJ
 */
public class Validation {

    public static boolean phoneNumber(JTextField textFild) {
        String txt = textFild.getText();
        if (txt.matches("^[0-9]{10}$")) {
            return true;
        }else{
            return false;
            }
        

    }

   public static boolean priceText(JTextField textField) {
        String text = textField.getText();
        if (text.matches("[0-9]+[.]?[0-9]{0,2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean nicValidation(JTextField nicTextField) {
        String text = nicTextField.getText();
        if (text.matches("[0-9]{9}[vV]")) {
            return true;
        } else {

            return false;
        }

    }

    public static boolean dobValidation(JTextField dobTextField) {
        String text = dobTextField.getText();
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOnly(JTextField textField) {
        String text = textField.getText();
        if (text.matches("^[\\d]*")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean name(JTextField textFild) {
        String text = textFild.getText();
         if (text.matches("^[A-Za-z// ]*$")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean date(String text) {
        if (text.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean time(JTextField textFild) {
        String text = textFild.getText();
        if (text.matches("^\\d\\d:\\d\\d$")) {
            return true;
        } else {
            return false;
        }
    }
    
     public static boolean validationEmail(JTextField textField) {
        String text = textField.getText();
        if (text.matches("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$")) {
           return true;
        }else{
            return false;
        }
     }

}