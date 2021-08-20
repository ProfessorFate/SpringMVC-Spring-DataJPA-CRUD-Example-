package contact.controller;

import contact.model.Contact;
import contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private ContactService contactService;

    @Autowired
    public MainController(ContactService contactService){
        this.contactService=contactService;
    }

    @GetMapping("/contact")
    public String geAllContact(Model model){
        model.addAttribute("contacts",contactService.list());
        return "contact";
    }

    @GetMapping("newContact")
    public String createContact(){
        return "addContact";
    }

    @PostMapping("/newContact")
    public String addContact(@ModelAttribute("contact")Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("contact",contactService.get(id));
        return "editContact";
    }

    @PostMapping("/editContact")
    public String editContact(@ModelAttribute("contact") Contact contact){
        contactService.edit(contact);
        return "redirect:/contact";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        contactService.delete(id);
        return "redirect:/contact";
    }




}




