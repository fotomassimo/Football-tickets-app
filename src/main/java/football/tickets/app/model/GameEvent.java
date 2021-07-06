package football.tickets.app.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GameEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Rivalry rivalry;
    @ManyToOne
    private Stadium stadium;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rivalry getRivalry() {
        return rivalry;
    }

    public void setRivalry(Rivalry rivalry) {
        this.rivalry = rivalry;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "GameEvent{"
                + "id=" + id
                + ", rivalry=" + rivalry
                + ", stadium=" + stadium
                + ", showTime=" + showTime + '}';
    }
}
