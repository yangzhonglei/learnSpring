package study.yzl.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenu implements Serializable {
    private Integer id;

    private String title;

    private String url;

    private Integer menuId;

    private Integer ord;

    private String icon;

    private Byte leaf;

    private Byte flag;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    
    private List<SysMenu> childMenus;
    
    
    
    
    /**
     * @方法名: parseMenuTree<br>
     * @描述: 组装菜单<br>
     * @param list 数据库里面获取到的全量菜单列表
     * @return
     */
	public static List<SysMenu> parseMenuTree(List<SysMenu> list) {

		List<SysMenu> result = new ArrayList<SysMenu>();
		if (list == null || list.size() < 1) {
			return result;
		}

		// 1、获取第一级节点
		for (SysMenu menu : list) {
			if (0 == menu.getMenuId()) {
				result.add(menu);
			}
		}

		// 2、递归获取子节点
		for (SysMenu parent : result) {
			parent = recursiveTree(parent, list);
		}

		return result;
	}

private static SysMenu recursiveTree(SysMenu parent, List<SysMenu> list) {
    for (SysMenu menu : list) {
        if(parent.getId() == menu.getMenuId()) {
	    menu = recursiveTree(menu, list);
	    if(parent.getChildMenus() == null) {
	    	parent.setChildMenus(new ArrayList<SysMenu>());
	    }
	    parent.getChildMenus().add(menu);
	}
    }
	    
    return parent;
}
	
	
	
    
    
    public List<SysMenu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<SysMenu> childMenus) {
		this.childMenus = childMenus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Byte getLeaf() {
        return leaf;
    }

    public void setLeaf(Byte leaf) {
        this.leaf = leaf;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysMenu other = (SysMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getOrd() == null ? other.getOrd() == null : this.getOrd().equals(other.getOrd()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getLeaf() == null ? other.getLeaf() == null : this.getLeaf().equals(other.getLeaf()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getOrd() == null) ? 0 : getOrd().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getLeaf() == null) ? 0 : getLeaf().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", url=").append(url);
        sb.append(", menuId=").append(menuId);
        sb.append(", ord=").append(ord);
        sb.append(", icon=").append(icon);
        sb.append(", leaf=").append(leaf);
        sb.append(", flag=").append(flag);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}