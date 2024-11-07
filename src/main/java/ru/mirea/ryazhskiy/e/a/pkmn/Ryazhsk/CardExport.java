package ru.mirea.ryazhskiy.e.a.pkmn.Ryazhsk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.mirea.ryazhskiy.e.a.pkmn.*;

public class CardExport {
    public static void cardSerialization(Card target) {
        try {
            File dir = new File("src/main/resources/crd");
            if (!dir.exists()) {
                dir.mkdirs(); // Создаём директорию, если она не существует
            }
            // Пишем файл в указанную директорию
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(dir, target.getName() + ".crd")));
            out.writeObject(target);
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка создания файла: " + e.getMessage());
        }
    }
}