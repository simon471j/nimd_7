package com.example.nmid_7.logic.model;

import com.example.nmid_7.logic.annotation.TreeNodeId;
import com.example.nmid_7.logic.annotation.TreeNodeLabel;
import com.example.nmid_7.logic.annotation.TreeNodePid;

import java.util.List;

public class Children {

    private List<String> children;
    private int courseId;
    @TreeNodeId
    private int id;
    @TreeNodeLabel
    private String name;
    private int order;
    @TreeNodePid
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;

    public Children(int id, String name, int parentChapterId) {
        this.id = id;
        this.name = name;
        this.parentChapterId = parentChapterId;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public boolean getUserControlSetTop() {
        return userControlSetTop;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getVisible() {
        return visible;
    }

    @Override
    public String toString() {
        return "Children{" +
                "children=" + children +
                ", courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", parentChapterId=" + parentChapterId +
                ", userControlSetTop=" + userControlSetTop +
                ", visible=" + visible +
                '}';
    }
}
