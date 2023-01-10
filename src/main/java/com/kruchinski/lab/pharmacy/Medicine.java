package com.kruchinski.lab.pharmacy;

import jakarta.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 2048)
    private String composition;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Substance active_substance;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Manufacturer manufacturer;

    protected Medicine() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Substance getActive_substance() {
        return active_substance;
    }

    public void setActive_substance(Substance active_substance) {
        this.active_substance = active_substance;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Medicine(Long id, String name, String composition, Substance active_substance, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.active_substance = active_substance;
        this.manufacturer = manufacturer;
    }

}
