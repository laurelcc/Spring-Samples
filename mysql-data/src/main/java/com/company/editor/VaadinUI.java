//package com.company.editor;
//
//import com.company.DO.User;
//import com.company.repository.UserRepository;
//import com.vaadin.server.FontAwesome;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.shared.ui.ValueChangeMode;
//import com.vaadin.spring.annotation.SpringUI;
//import com.vaadin.ui.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//
///**
// * Created by huanbenwang on 2017/7/6.
// */
//@SpringUI
//public class VaadinUI extends UI{
//    private final UserRepository repo;
//
//    private final UserEditor editor;
//
//    final Grid<User> grid;
//
//    final TextField filter;
//
//    private final Button addNewBtn;
//
//    @Autowired
//    public VaadinUI(UserRepository repo, UserEditor editor) {
//        this.repo = repo;
//        this.editor = editor;
//        this.grid = new Grid<>(User.class);
//        this.filter = new TextField();
//        this.addNewBtn = new Button("New customer", FontAwesome.PLUS);
//    }
//
//    @Override
//    protected void init(VaadinRequest request) {
//        // build layout
//        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
//        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
//        setContent(mainLayout);
//
//        grid.setHeight(300, Unit.PIXELS);
//        grid.setWidth(100, Unit.PERCENTAGE);
//        grid.setColumns("id", "name", "email");
//
//        filter.setPlaceholder("Filter by name");
//
//        // Hook logic to components
//
//        // Replace listing with filtered content when user changes filter
//        filter.setValueChangeMode(ValueChangeMode.LAZY);
//        filter.addValueChangeListener(e -> listCustomers(e.getValue()));
//
//        // Connect selected Customer to editor or hide if none is selected
//        grid.asSingleSelect().addValueChangeListener(e -> {
//            editor.editCustomer(e.getValue());
//        });
//
//        // Instantiate and edit new Customer the new button is clicked
//        addNewBtn.addClickListener(e -> editor.editCustomer(new User("", "")));
//
//        // Listen changes made by the editor, refresh data from backend
//        editor.setChangeHandler(() -> {
//            editor.setVisible(false);
//            listCustomers(filter.getValue());
//        });
//
//        // Initialize listing
//        listCustomers(null);
//    }
//
//    // tag::listCustomers[]
//    void listCustomers(String filterText) {
//        if (StringUtils.isEmpty(filterText)) {
//            grid.setItems(repo.findAll());
//        }
//        else {
//            grid.setItems(repo.findByNameStartsWithIgnoreCase(filterText));
//        }
//    }
//    // end::listCustomers[]
//}
