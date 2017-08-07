package com.newer.crud;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author wtao
 *
 */
public class Db {

	private static LinkedList<Staff> staffs;

	static {
		staffs = new LinkedList<Staff>();
		staffs.add(new Staff(1, "alice", "131"));
		staffs.add(new Staff(2, "bob", "139"));
		staffs.add(new Staff(3, "rose", "150"));
	}

	/**
	 * 创建
	 * 
	 * @param staff
	 */
	public static void save(Staff staff) {
		staffs.add(staff);
	}

	/**
	 * 查询获得所有数据
	 * 
	 * @return
	 */
	public static List<Staff> findAll() {
		return staffs;
	}

	/**
	 * 根据 id 查询员工
	 * 
	 * @param id
	 * @return 员工或 null(不存在)
	 */
	public static Staff find(int id) {
		for (Staff s : staffs) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	/**
	 * 更新
	 * 
	 * @param s
	 */
	public static void update(Staff s) {
		for (int i = 0; i < staffs.size(); i++) {
			if (staffs.get(i).getId() == s.getId()) {
				staffs.get(i).setName(s.getName());
				staffs.get(i).setPhone(s.getPhone());
				break;
			}
		}
	}

	/**
	 * 删除特定的员工
	 * 
	 * @param id
	 *            编号
	 * @return
	 */
	public static boolean delete(int id) {
		boolean isDelete = false;
		for (int i = 0; i < staffs.size(); i++) {
			Staff s = staffs.get(i);
			if (s.getId() == id) {
				staffs.remove(i);
				isDelete = true;
				break;
			}
		}
		return isDelete;
	}

}
