package com.kaankubat.hichatapplication.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class BlockModel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    Long angryId;

    @NotNull
    Long blockedId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAngryId() {
        return angryId;
    }

    public void setAngryId(Long angryId) {
        this.angryId = angryId;
    }

    public Long getBlockedId() {
        return blockedId;
    }

    public void setBlockedId(Long blockedId) {
        this.blockedId = blockedId;
    }
}
