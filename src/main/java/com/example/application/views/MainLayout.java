package com.example.application.views;


import com.example.application.data.BudgetItems;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;



import java.util.Collections;

@PageTitle("Budget")
@Route(value = "")
public class MainLayout extends VerticalLayout {

//   TextField item = new TextField();
//   TextField cost = new TextField();

   TextField monthlyBudget = new TextField();
   Button addBudgetButton = new Button("Add Budget");
   Label budgetLabel = new Label("Budget");

   //Grid<BudgetItems> grid = new Grid<>(BudgetItems.class);
   //Button removeItem = new Button("RemoveItem");

   TextField item = new TextField("Item");
   TextField cost = new TextField("Cost");
   Button addItemButton = new Button("Add Item");

   VerticalLayout toolbar = new VerticalLayout(item, cost, addItemButton);

   public MainLayout() {
      addClassName("Main-layout");
      setSizeFull();

      addBudgetButton.addClickListener(click -> budgetLabel.setText(monthlyBudget.getValue()));
      addItemButton.addClickListener(click -> addItemButtonTasks(toolbar));

      //configureGrid();

      add(
        getToolbar(),
        getToolbar2()
      );

   }

   private Component getToolbar(){

     // addItem.addClickListener(click -> grid.add

      HorizontalLayout toolbar = new HorizontalLayout(monthlyBudget, addBudgetButton, budgetLabel);
      return toolbar;
   }

   private Component getToolbar2()
   {
      return toolbar;
   }


   private void addItemButtonTasks(VerticalLayout toolbarI)
   {
      toolbar.addComponentAsFirst(new Label(item.getValue() + " " + cost.getValue()));

      String budgetT = monthlyBudget.getValue().toString();
      int budgetI = Integer.parseInt(budgetT);

      String costT = cost.getValue().toString();
      int costI = Integer.parseInt(costT);

      budgetI -= costI;
      budgetLabel.setText(Integer.toString(budgetI));

   }


//   private void configureGrid() {
//      grid.addClassName("contact-grid");
//      grid.setSizeFull();
//      grid.setColumns("item", "cost");
//      grid.addComponentColumn(item -> new Button("Delete", click -> {
//
//      }));
//      grid.getColumns().forEach(col -> col.setAutoWidth(true));
//
//   }




}
