package Backend;

import javax.swing.JOptionPane;

public class GroupCreator extends GroupAdmin{

    private String groupCreatorId;
    
    public GroupCreator(String userId) {
        super(userId);
        this.groupCreatorId = userId;
    }

    public String getGroupCreatorId() {
        return groupCreatorId;
    }
    
    public void promoteGroupAdmin(String groupId, String groupUserId) {
        GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
        if(groupMemberDatabase.groupUserFound(groupId,groupUserId)) {
            groupMemberDatabase.removeUserFromGroupMembersFile(groupId, groupUserId);
            GroupAdmin groupAdmin = new GroupAdmin(groupUserId);
            groupMemberDatabase.addAdmin(groupId, groupAdmin);
            JOptionPane.showMessageDialog(null, "Successfully promoted user with ID: " +groupUserId+ " to admin role.");
        }
        else
            JOptionPane.showMessageDialog(null, "User with ID: " +groupUserId+ " does not exist.");
    }
    
    public void demoteGroupAdmin(String groupId, String groupAdminId) {
        GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
        if(groupMemberDatabase.groupAdminFound(groupId,groupAdminId)) {
            groupMemberDatabase.removeAdminFromGroupMembersFile(groupId, groupAdminId);
            GroupUser groupUser = new GroupUser(groupAdminId);
            groupMemberDatabase.addUser(groupId, groupUser);
            JOptionPane.showMessageDialog(null, "Successfully demoted user with ID: " +groupAdminId+ " to normal user role.");
        }
        else
            JOptionPane.showMessageDialog(null, "User with ID: " +groupAdminId+ " does not exist.");
    }
    
    public void removeGroupAdmin(String groupId, String groupAdminId) {
        if (groupId == null || groupAdminId == null) {
            JOptionPane.showMessageDialog(null, "Invalid groupID or adminID.");
            return;
        }
        if(GroupMemberDatabase.groupAdminFound(groupId, groupAdminId)) {
            GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
            groupMemberDatabase.removeAdminFromGroupMembersFile(groupId, groupAdminId);
        }
        else
            JOptionPane.showMessageDialog(null, "User with ID: " +groupAdminId+ " is not in this group.");
    }
    
    public void deleteGroup(String groupId) {
        GroupManagement.deleteGroup(groupId);
    }
    
    @Override
    public void leaveGroup(String groupId) {
        if (groupId == null || this.getGroupUserId() == null) {
            JOptionPane.showMessageDialog(null, "Invalid groupID or userID.");
            return;
        }
        if(GroupMemberDatabase.groupAdminFound(groupId, this.getGroupUserId())) {
            GroupMemberDatabase groupMemberDatabase = new GroupMemberDatabase();
            groupMemberDatabase.removeAdminFromGroupMembersFile(groupId, this.getGroupUserId());
            GroupManagement.deleteGroup(groupId);
        }
        else
            JOptionPane.showMessageDialog(null, "You are not in this group.");
    }
}
