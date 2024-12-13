/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.GroupManagament;

/**
 *
 * @author DELL-G3
 */
import Backend.GroupManagament.Group;
import java.util.ArrayList;
import java.util.List;

public class GroupManager {
    private List<Group> groups;

    public GroupManager() {
        this.groups = new ArrayList<>();
    }

    // Add a group to the list
    public void addGroup(Group group) {
        this.groups.add(group);
    }

    // Search for groups by name
    public List<Group> searchGroupsByName(String name) {
        List<Group> matchingGroups = new ArrayList<>();
        for (Group group : groups) {
            if (group.getGroupName().toLowerCase().contains(name.toLowerCase())) {
                matchingGroups.add(group);
            }
        }
        return matchingGroups;
    }
}
