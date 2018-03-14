package com.rewardshoop.model;

public class Type {
    private Integer id;

    private String typeName;

    private String typePic;

    public Type(Integer id, String typeName, String typePic) {
        this.id = id;
        this.typeName = typeName;
        this.typePic = typePic;
    }

    public Type() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypePic() {
        return typePic;
    }

    public void setTypePic(String typePic) {
        this.typePic = typePic == null ? null : typePic.trim();
    }
}