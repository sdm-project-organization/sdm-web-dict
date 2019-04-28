package com.sdm.multilingual.models.resources;

import com.sdm.multilingual.constants.ActiveFlag;
import com.sdm.multilingual.constants.EnableFlag;
import com.sdm.multilingual.models.tables.Partition;
import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Data
public class PartitionResource extends CommonResource<Partition, PartitionResource> {

    // * Boxed Class 필수
    private Integer serviceSequence;
    private Byte exportType;
    private String exportUrl;

    @Override
    public PartitionResource toInsert() {
        setServiceSequence(1); // TODO AUTOMATIC
        setActiveFlag(ActiveFlag.Y.getValue());
        setEnableFlag(EnableFlag.Y.getValue());
        return this;
    }

    @Override
    public PartitionResource toUpdate() {
        setServiceSequence(1); // TODO AUTOMATIC
        return this;
    }

    @Override
    public Partition toEntity() {
        Partition partition = new Partition();
        partition.setServiceSequence(this.getServiceSequence());
        partition.setExportType(this.getExportType());
        partition.setExportUrl(this.getExportUrl());
        partition.setDisplayOrder(this.getDisplayOrder());
        partition.setDisplayName(this.getDisplayName());
        partition.setDesc(this.getDesc());
        partition.setActiveFlag(this.getActiveFlag());
        partition.setEnableFlag(this.getEnableFlag());
        return partition;
    }

}