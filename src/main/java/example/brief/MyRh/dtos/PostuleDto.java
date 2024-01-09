package example.brief.MyRh.dtos;

import example.brief.MyRh.Enum.ConnectedStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostuleDto {
    private CandidateDTO candidateDTO;
    private String cv;
    private int tel;
    private String motivation;
    private ConnectedStatus postuleStatus;
}
