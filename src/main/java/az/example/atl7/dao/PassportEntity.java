package az.example.atl7.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "passport")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pin;
    private String serialNumber;
//    @OneToOne(mappedBy = "passportEntity")
//    @JsonBackReference
//    private CustomerEntity customerEntity;
}
