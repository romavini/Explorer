package io.github.mdcdxcvi;

import java.util.ResourceBundle;
import java.util.Locale;

public class Language {
    private Locale locale;
    public static ResourceBundle messages;
    public String lang;
    public String country;

    Language(){
        // default lamguage is potuguese
        this.lang = "pt";
        this.country = "PT";
        this.locale = new Locale(this.lang, this.country);
        messages = ResourceBundle.getBundle("MessageBundle", this.locale);
    }

    Language(String lang, String country){
        this.lang = lang;
        this.country = country;
        this.locale = new Locale(this.lang,this.country);
        messages = ResourceBundle.getBundle("MessageBundle", this.locale);
    }

    public String getMessage(String key){
        return messages.getString(key);
    } 

}