package ru.mirea.ryazhskiy.e.a.pkmn.web.jdbc;


import ru.mirea.ryazhskiy.e.a.pkmn.Student;
import ru.mirea.ryazhskiy.e.a.pkmn.Card;

import java.util.UUID;

public interface DatabaseService {
    Card getCardFromDatabase(String cardName);

    Student getStudentFromDatabase(String studentName);

    void saveCardToDatabase(Card card);

    UUID createPokemonOwner(Student owner);
}