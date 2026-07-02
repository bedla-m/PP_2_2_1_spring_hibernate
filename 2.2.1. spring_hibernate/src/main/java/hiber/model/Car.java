package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return " Car: " + " series = " + series + " model = " + model;
    }
}
