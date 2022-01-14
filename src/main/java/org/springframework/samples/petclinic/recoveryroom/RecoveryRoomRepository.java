package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    //List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name=?1")
    RecoveryRoomType finTypeByName(String name);
    //RecoveryRoomType getRecoveryRoomType(String name);
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size>=?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
