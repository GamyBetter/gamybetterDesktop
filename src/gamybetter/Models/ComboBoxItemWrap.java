/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author skon1
 * @param <T>
 */
public class ComboBoxItemWrap<T> {

    private BooleanProperty check = new SimpleBooleanProperty(false);
    private ObjectProperty<T> item = new SimpleObjectProperty<>();

    public ComboBoxItemWrap() {
    }

    public ComboBoxItemWrap(T item) {
        this.item.set(item);
    }

    public ComboBoxItemWrap(T item, Boolean check) {
        this.item.set(item);
        this.check.set(check);
    }

    public BooleanProperty checkProperty() {
        return check;
    }

    public Boolean getCheck() {
        return check.getValue();
    }

    public void setCheck(Boolean value) {
        this.check.set(value);
    }

    public ObjectProperty<T> itemProperty() {
        return item;
    }

    public T getItem() {
        return item.getValue();
    }

    public void setItem(T value) {
        item.setValue(value);
    }

    @Override
    public String toString() {
        return item.getValue().toString();
    }

}

//initialize choiceboxcours
        /*ObservableList<ComboBoxItemWrap<Cours>> options = FXCollections.observableArrayList(
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours())
        );*/

/*ComboBox<ComboBoxItemWrap<Cours>> cb = new ComboBox<>();
        @SuppressWarnings("unchecked")
        ObservableList<ComboBoxItemWrap<Cours>> options = FXCollections.observableArrayList(
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours()),
                new ComboBoxItemWrap<>(new Cours())
        );
        cb.setCellFactory(c -> {
            ListCell<ComboBoxItemWrap<Cours>> cell = new ListCell<>() {
                @Override
                protected void updateItem(ComboBoxItemWrap<Cours> item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        final CheckBox cb = new CheckBox(item.toString());
                        cb.selectedProperty().bind(item.checkProperty());
                        setGraphic(cb);
                    }
                }
            };
            cell.addEventFilter(MouseEvent.MOUSE_RELEASED, event -> {
                cell.getItem().checkProperty().set(!cell.getItem().checkProperty().get());
                StringBuilder sb = new StringBuilder();
                cb.getItems().filtered(f -> f != null).filtered(f -> f.getCheck()).forEach(p -> {
                    sb.append("; " + p.getItem());
                });
                final String string = sb.toString();
                cb.setPromptText(string.substring(Integer.min(2, string.length())));
            });
            return cell;
        });
         */