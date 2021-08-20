package contact.service;

import contact.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> list();

    void save(Contact contact);

    void edit(Contact contact);

    void delete(int id);

    Contact get(int id);
}
