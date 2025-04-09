package module_9.localization;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class UseResourceBundle {
    public static void main(String[] args) {
//        Locale locale = Locale.US;
//        Locale locale = Locale.UK;
//        Locale locale = Locale.CANADA_FRENCH;
        Locale locale = Locale.GERMANY;

        Locale.setDefault(locale);

        System.out.println("For Locale: " + locale + " -----------------------");
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("module_9.localization.MyResources");

        System.out.println("car-engine-cover: " + resourceBundle.getString("car-engine-cover"));
        System.out.println("cake: " + resourceBundle.getString("cake"));
        System.out.println("baked-items: " + resourceBundle.getString("baked-items"));
        System.out.println("affirmation: " + resourceBundle.getString("affirmation"));


        try {
            ResourceBundle resourceBundle1 = PropertyResourceBundle.getBundle("badname");
        } catch (Exception e) {
            System.out.println("get of resource bundle \"badname\" failed with " + e);
        }
    }
}
