package com.lz.retrofit_sample.simpledemo;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("id")
    private String id;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;

    @SerializedName("owner")
    private Owner owner;

    class Owner {
        @SerializedName("login")
        private String login;
        @SerializedName("id")
        private String id;
        @SerializedName("node_id")
        private String nodeID;
        @SerializedName("avatar_url")
        private String avatarUrl;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNodeID() {
            return nodeID;
        }

        public void setNodeID(String nodeID) {
            this.nodeID = nodeID;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id");
        stringBuilder.append(":");
        stringBuilder.append(id);
        stringBuilder.append(" ");
        stringBuilder.append("node_id");
        stringBuilder.append(":");
        stringBuilder.append(nodeId);
        stringBuilder.append(" ");
        stringBuilder.append("name");
        stringBuilder.append(":");
        stringBuilder.append(name);
        stringBuilder.append(" ");
        stringBuilder.append("full_name");
        stringBuilder.append(":");
        stringBuilder.append(fullName);
        stringBuilder.append(" ");
        stringBuilder.append("owner");
        stringBuilder.append("{");
        stringBuilder.append("login");
        stringBuilder.append(":");
        stringBuilder.append(owner.getLogin());
        stringBuilder.append(" ");
        stringBuilder.append("ownerId");
        stringBuilder.append(":");
        stringBuilder.append(owner.getId());
        stringBuilder.append(" ");
        stringBuilder.append("node_id");
        stringBuilder.append(":");
        stringBuilder.append(owner.getNodeID());
        stringBuilder.append(" ");
        stringBuilder.append("avatar_url");
        stringBuilder.append(":");
        stringBuilder.append(owner.getAvatarUrl());
        stringBuilder.append(" ");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
