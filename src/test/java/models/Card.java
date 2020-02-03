package models;

public class Card {
    String number;
    String month;
    String year;
    String nameLastName;

    public Card(String number, String month, String year, String nameLastName) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.nameLastName = nameLastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNameLastName() {
        return nameLastName;
    }

    public void setNameLastName(String nameLastName) {
        this.nameLastName = nameLastName;
    }
}
