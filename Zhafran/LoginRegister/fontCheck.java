package Zhafran.LoginRegister;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
public class fontCheck {
    public static void main(String[] args) {
        // Mendapatkan array dari semua font yang tersedia
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        // Menampilkan daftar font
        System.out.println("Available Fonts:");
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
    }
}
