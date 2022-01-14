package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recovery_rooms")
public class RecoveryRoom extends BaseEntity {
    @NotNull
    @Size(min = 3, max = 50)
    String name;

    @Min(0)
    @NotNull
    double size;

    @NotNull
    boolean secure;



    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name="recovery_room_type_id")
    RecoveryRoomType roomType;
}
