package cn.tjsanshao.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BagItem {
    private Integer id;

    private String bagItemName;

    private String bagItemDesc;

    private String bagItemSpriteName;

    private Byte bagItemType;

    private BigDecimal bagItemSalePrice;

    private BigDecimal bagItemBuyPrice;

    private Integer bagItemRecoverValue;

    private Byte bagItemDrugType;

    private String bagItemRecover;

    private Float bagItemSkillDuration;

    private Float bagItemSkillValue;

    private String bagItemSkill;
}