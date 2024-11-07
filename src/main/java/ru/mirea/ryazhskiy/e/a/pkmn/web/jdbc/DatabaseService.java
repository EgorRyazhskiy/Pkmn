package ru.mirea.ryazhskiy.e.a.pkmn.web.jdbc;


import com.fasterxml.jackson.core.JsonProcessingException;
import ru.mirea.ryazhskiy.e.a.pkmn.Student;
import ru.mirea.ryazhskiy.e.a.pkmn.Card;

import java.sql.SQLException;
import java.util.UUID;

public interface DatabaseService {
    Card getCardFromDatabase(String cardName) throws SQLException, JsonProcessingException;

    Student getStudentFromDatabase(String studentName) throws SQLException;

    void saveCardToDatabase(Card card) throws SQLException;

    void createPokemonOwner(Student owner) throws SQLException;
}