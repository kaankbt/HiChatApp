package com.kaankubat.hichatapplication.repository;

import com.kaankubat.hichatapplication.model.BlockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<BlockModel,Long> {
    List<BlockModel> findByAngryId(Long angryId);

    @Transactional
    @Modifying
    @Query("delete from BlockModel b where b.angryId = :angryId and b.blockedId = :blockedId")
    void unblock(Long angryId, Long blockedId);
}
