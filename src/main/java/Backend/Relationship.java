/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend;

/**
 *
 * @author DELL-G3
 */

public class Relationship {
    private String relationWith;
    private RelationshipStatus relation;

    public Relationship( RelationshipStatus relation,String relationWith) {
        this.relationWith = relationWith;
        this.relation = relation;
    }
    public void setFriend() {
        relation.setFriend();
    }
    public void setBlock() {
        relation.setBlock();
    }
    public void setCancel() {
        relation.setCanceled();
    }
    public String getRelation() {
        return relation.getRelation();
    }

    public String getrelationWith() {
        return relationWith;
    }

    public void setRelation(RelationshipStatus relation) {
        this.relation = relation;
    }

}
