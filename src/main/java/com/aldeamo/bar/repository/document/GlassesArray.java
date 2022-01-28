package com.aldeamo.bar.repository.document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "arrays")
public class GlassesArray implements Serializable {
    @Id
    private int id;

    @Column
    private String input_array;


    public GlassesArray(int id, String input_array) {
        this.id = id;
        this.input_array = input_array;

    }

    public GlassesArray() {
    }

    public String getInput_array() {
        return input_array;
    }

    public void setInput_array(String input_array) {
        this.input_array = input_array;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
