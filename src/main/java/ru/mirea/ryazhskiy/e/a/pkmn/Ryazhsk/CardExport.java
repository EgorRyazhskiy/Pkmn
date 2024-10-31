package ru.mirea.ryazhskiy.e.a.pkmn.Ryazhsk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.mirea.ryazhskiy.e.a.pkmn.*;

public class CardExport {
    public static void cardSerialization(Card target) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\crd\\" + target.getName() + ".crd"));

            out.writeObject(target);
            out.flush();
            out.close();
        }
        catch (IOException e){
            throw new RuntimeException("Ошибка создания файла");
        }
    }
}