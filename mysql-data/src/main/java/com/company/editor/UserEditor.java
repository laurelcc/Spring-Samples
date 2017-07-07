//package com.company.editor;
//
//import com.company.DO.User;
//import com.company.repository.UserRepository;
//import com.vaadin.data.Binder;
//import com.vaadin.event.ShortcutAction;
//import com.vaadin.server.FontAwesome;
//import com.vaadin.spring.annotation.SpringComponent;
//import com.vaadin.spring.annotation.UIScope;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.CssLayout;
//import com.vaadin.ui.TextField;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.themes.ValoTheme;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.UUID;
//
///**
// * Created by huanbenwang on 2017/7/6.
// */
//@SpringComponent
//@UIScope
//public class UserEditor extends VerticalLayout {
//
//    private final UserRepository userRepository;
//
//    private User user;
//
//    TextField name = new TextField("Name");
//    TextField email = new TextField("Email");
//
//    Button save = new Button("Save", FontAwesome.SAVE);
//    Button cancel = new Button("Cancel");
//    Button delete = new Button("Delete", FontAwesome.TRASH_O);
//    CssLayout actions = new CssLayout(save, cancel, delete);
//
//    Binder<User> binder = new Binder<>(User.class);
//
//    @Autowired
//    public UserEditor(UserRepository repository) {
//        this.userRepository = repository;
//
//        addComponents(name, email, actions);
//
//        // bind using naming convention
//        binder.bindInstanceFields(this);
//
//        // Configure and style components
//        setSpacing(true);
//        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
//        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
//
//        // wire action buttons to save, delete and reset
//        save.addClickListener(e -> {
//            user.setId(UUID.randomUUID().toString());
//            repository.save(user);
//        });
//        delete.addClickListener(e -> repository.delete(user));
//        cancel.addClickListener(e -> editCustomer(user));
//        setVisible(false);
//    }
//
//    public interface ChangeHandler {
//
//        void onChange();
//    }
//
//    public final void editCustomer(User c) {
//        if (c == null) {
//            setVisible(false);
//            return;
//        }
//        final boolean persisted = c.getId() != null;
//        if (persisted) {
//            // Find fresh entity for editing
//            user = userRepository.findOne(c.getId());
//        }
//        else {
//            user = c;
//        }
//        cancel.setVisible(persisted);
//
//        // Bind customer properties to similarly named fields
//        // Could also use annotation or "manual binding" or programmatically
//        // moving values from fields to entities before saving
//        binder.setBean(user);
//
//        setVisible(true);
//
//        // A hack to ensure the whole form is visible
//        save.focus();
//        // Select all text in firstName field automatically
//        name.selectAll();
//    }
//
//    public void setChangeHandler(ChangeHandler h) {
//        // ChangeHandler is notified when either save or delete
//        // is clicked
//        save.addClickListener(e -> h.onChange());
//        delete.addClickListener(e -> h.onChange());
//    }
//}
