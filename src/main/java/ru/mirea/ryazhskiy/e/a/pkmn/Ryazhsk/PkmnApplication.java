package ru.mirea.ryazhskiy.e.a.pkmn.Ryazhsk;

import ru.mirea.ryazhskiy.e.a.pkmn.Card;
import ru.mirea.ryazhskiy.e.a.pkmn.web.http.PkmnHttpClient;
import ru.mirea.ryazhskiy.e.a.pkmn.web.jdbc.DatabaseServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

public class PkmnApplication {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        // Создаем HTTP-клиент и сервис базы данных
        PkmnHttpClient httpClient = new PkmnHttpClient();
        DatabaseServiceImpl db = new DatabaseServiceImpl();

        // Импортируем данные карточки из текстового файла
        Card myCard = CardImport.importCardFromTxt("src/main/resources/my_card.txt");
        // Обновляем атакующие навыки карточки с использованием HTTP-клиента
        CardImport.updateAttackSkill(myCard, httpClient);

        // Сохраняем карточку в базе данных
        db.saveCardToDatabase(myCard);

        // Выводим характеристики карточки на экран
        System.out.println("Характеристики карты:");
        System.out.println("Стадия покемона: " + myCard.getPokemonStage());
        System.out.println("Имя: " + myCard.getName());
        System.out.println("HP: " + myCard.getHp());
        System.out.println("Тип покемона: " + myCard.getPokemonType());
        System.out.println("Эволюция из: " + (myCard.getEvolvesFrom() != null ? myCard.getEvolvesFrom().getName() : "None"));
        System.out.println("Список умений:");
        myCard.getSkills().forEach(skill -> {
            System.out.println("  Умение: " + skill.getName());
            System.out.println("    Описание: " + skill.getDescription());
            System.out.println("    Стоимость: " + skill.getCost());
            System.out.println("    Урон: " + skill.getDamage());
        });
        System.out.println("Тип слабости: " + (myCard.getWeaknessType() != null ? myCard.getWeaknessType() : "None"));
        System.out.println("Тип сопротивления: " + (myCard.getResistanceType() != null ? myCard.getResistanceType() : "None"));
        System.out.println("Стоимость отступления: " + myCard.getRetreatCost());
        System.out.println("Игровой набор: " + myCard.getGameSet());
        System.out.println("Знак регуляции: " + myCard.getRegulationMark());
        System.out.println("Владелец карты: " + myCard.getPokemonOwner());
        System.out.println("Номер: " + myCard.getNumber());

        // Создаём и используем экземпляр CardExport для сохранения карточки на диск
        CardExport.cardSerialization(myCard);
        System.out.println("Карточка успешно сохранена на диск.");

       //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // Десериализация объекта Flygon из файла Flygon.crd
        /*Card importCard = CardImport.cardImportByte("src/main/resources/crd/Flygon.crd");
        System.out.println("\nЗагружена карта покемона:");
        System.out.println("Имя: " + importCard.getName());
        System.out.println("HP: " + importCard.getHp());
        System.out.println("Тип покемона: " + importCard.getPokemonType());
        System.out.println("Список умений:");
        importCard.getSkills().forEach(skill -> {
            System.out.println("  Умение: " + skill.getName());
            System.out.println("    Описание: " + skill.getDescription());
            System.out.println("    Стоимость: " + skill.getCost());
            System.out.println("    Урон: " + skill.getDamage());
        });
        System.out.println("Тип слабости: " + (importCard.getWeaknessType() != null ? importCard.getWeaknessType() : "None"));
        System.out.println("Стоимость отступления: " + importCard.getRetreatCost());
        System.out.println("Игровой набор: " + importCard.getGameSet());
        System.out.println("Знак регуляции: " + importCard.getRegulationMark());
        System.out.println("Владелец карты " + importCard.getPokemonOwner());
        System.out.println("Номер: " + importCard.getNumber());*/
    }
}
