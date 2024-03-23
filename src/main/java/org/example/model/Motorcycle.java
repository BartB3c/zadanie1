package org.example.model;


public class Motorcycle extends Vehicle{
    private final String kategoria;

    public String getKategoria() {
        return kategoria;
    }

    public Motorcycle(String brand, String model, int year, double price, String licencePlate, boolean rented, String kategoria) {
        super(brand, model, year, price, licencePlate, rented);
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "marka='" + super.getBrand() + '\'' +
                ", model: '" + super.getModel() + '\'' +
                ", rok: " + super.getYear() + '\'' +
                ", cena: " + super.getPrice() + '\'' +
                ", rejestracja: " + super.getLicencePlate() + '\'' +
                ", wypożyczony: " + super.rented() + '\'' +
                ", kategoria: " + this.getKategoria() + '\'';

    }

    @Override
    public String toCSV() {
        return "Motorcycle;" + getBrand() + ";" + getModel() + ";" + getYear() + ";" +  getPrice() + ";" + getLicencePlate() + ";" + rented() + ";" + getKategoria();
    }
}
