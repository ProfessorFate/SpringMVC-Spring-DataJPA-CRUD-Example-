package contact.service;

import contact.model.Contact;
import contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public List<Contact> list() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public void edit(Contact contact) {
    }

    @Override
    @Transactional
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact get(int id) {
        return contactRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void save(Contact contact) {
        contactRepository.save(contact);
    }
}
