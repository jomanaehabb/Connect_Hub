package Backend;

public class GroupCreator extends GroupAdmin{

    private String groupCreatorId;
    
    public GroupCreator(String userId) {
        super(userId);
        this.groupCreatorId = userId;
    }

    public String getGroupCreatorId() {
        return groupCreatorId;
    }
}
