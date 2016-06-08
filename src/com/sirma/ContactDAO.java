package com.sirma;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 6/8/2016.
 */
public interface ContactDAO {
    // Добавление контакта - возвращает ID добавленного контакта
    public Long addContact(Contact contact) throws IOException;
    // Удаление контакта по его ID
    public void deleteContact(Long contactId);
    public Contact getContact(Long contactId);
    // Получение списка контактов
    public List<Contact> showContacts();

    public void loadFile();
}
