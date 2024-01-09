package example.brief.MyRh.entities;

import example.brief.MyRh.Enum.ConnectedStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import example.brief.MyRh.Enum.CompteStatus;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Societe {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)

    private Long id;
    private String email;
    private String password;
    private String adresse;
    private int phone;
    private String image;
    private String code;
    @Enumerated(EnumType.STRING)
    private CompteStatus status;
    @Enumerated(EnumType.STRING)
    private ConnectedStatus connected;
    @OneToMany(mappedBy = "societe", fetch = FetchType.LAZY )
    private List<Offre> offre;

    @PrePersist
    @PreUpdate
    public void checkStatus(){
        if (this.status == null || this.status.describeConstable().isEmpty()){
            this.status = CompteStatus.INVALID;
        }
        if (this.connected == null || this.connected.describeConstable().isEmpty()){
            this.connected = ConnectedStatus.DISCONNECT;
        }
    }
}
