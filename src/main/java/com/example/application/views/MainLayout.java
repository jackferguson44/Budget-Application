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

   Grid<BudgetItems> grid = new Grid<>(BudgetItems.class);
   Button removeItem = new Button("RemoveItem");

   TextField item = new TextField("Item");
   TextField cost = new TextField("Cost");
   Button addItem = new Button("Add Item");

   public MainLayout() {
      addClassName("Main-layout");
      setSizeFull();

      configureGrid();

      add(
        getToolbar(),
        getGrid()
      );

   }

   private Component getToolbar(){
      addBudgetButton.addClickListener(click -> budgetLabel.setText(monthlyBudget.getValue()));

      HorizontalLayout toolbar = new HorizontalLayout(monthlyBudget, addBudgetButton, budgetLabel, item, cost, addItem);
      return toolbar;
   }

   private Component getGrid()
   {
      HorizontalLayout content = new HorizontalLayout(grid);
      content.setFlexGrow(2, grid);
      content.addClassName("content");
      content.setSizeFull();
      return content;
   }



   private void configureGrid() {
      grid.addClassName("contact-grid");
      grid.setSizeFull();
      grid.setColumns("item", "cost");
      grid.addComponentColumn(item -> new Button("Delete", click -> {

      }));
      grid.getColumns().forEach(col -> col.setAutoWidth(true));

   }




}
