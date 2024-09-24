package model;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IoTDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}