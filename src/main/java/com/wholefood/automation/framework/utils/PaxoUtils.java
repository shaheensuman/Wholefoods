package com.wholefood.automation.framework.utils;


import com.google.common.base.CharMatcher;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaxoUtils {
    public static String getUniqueFileName(String nameStartName, String fileExt){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        nameStartName = nameStartName  + "-" + dateFormat.format(new Date());
        nameStartName = CharMatcher.anyOf("- .").replaceFrom(nameStartName, "_")  + "." + fileExt;
        return nameStartName;
    }

    public static String createDirectory(String path){

        if(!path.endsWith(File.separator)){
            path = path + File.separator;
        }
        try{
            if(!new File(path).exists()){
                FileUtils.forceMkdir(new File(path));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return path;
    }

    /**********************************************
     * Helper Method to validate true or false
     * *******************************************/
    public static boolean isTrue(String checkValue) {
        Boolean result = false;
        if (checkValue.equals("1") || checkValue.toLowerCase().equals("true") ||
                checkValue.toLowerCase().equals("yes") || checkValue.toLowerCase().equals("y") ||
                checkValue.toLowerCase().equals("t")) {
            result = true;
        }
        return result;
    }

    /**
     * This function is mainly used by TestNG data provider
     *
     * @param mapList
     * @param log
     * @return
     */
    public static Object[][] listHashMapToObject(
            List<HashMap<String, String>> mapList) {
        Object[][] data = new Object[mapList.size()][1];
        {
            for(int i=0;i<mapList.size();i++)
                data[i][0] = mapList.get(i);
        }
        return data;
    }

    public static List<String> USPhoneNumber(String string) {
        List<String> phoneNumbers = new ArrayList<String>();
        String regexPhone = "\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})";
        Pattern paternPhone = Pattern.compile(regexPhone);
        Matcher matcherPhone = paternPhone.matcher(string);
        while (matcherPhone.find()) {
            phoneNumbers.add(matcherPhone.group());
        }
        return phoneNumbers;
    }

    public static List<String> emailAddresses(String string) {
        List<String> emails = new ArrayList<String>();
        String regexEmail = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(string);
        while (matcherEmail.find()) {
            emails.add(matcherEmail.group());
        }
        return emails;
    }

    public static String getTimeStamp() {
        Date date = new Date();
        return new Timestamp(date.getTime()).toString();
    }



    public static String getFileNameFromURL(String URL) {
        String fileName = "";
        String[] path = URL.split("/");
        if (URL.endsWith("/"))
            fileName = path[path.length - 1];
        else {
            String[] fileNameSplit = path[path.length - 1].split(".");
            if (fileNameSplit.length > 0)
                fileName = path[path.length - 1];
        }
        return fileName;
    }
}