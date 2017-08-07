package com.newer.crud;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/staff")
public class StaffController {

	/**
	 * 显示所有数据（转发给 show.jsp）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String show(Model m) {
		System.out.println("show");

		// 加载数据
		List<Staff> list = Db.findAll();
		m.addAttribute("staffs", list);

		return "show";
	}

	/**
	 * 创建一个新数据（重定向到 show）
	 * 
	 * @param staff
	 *            新的数据
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String create(Staff staff) {
		// System.out.println("create: " + staff.toString());

		// 自动
		// String id = request.getParameter("id");
		// String name = request.getParameter("user");
		// String id = request.getParameter("phone");

		Db.save(staff);

		return "redirect:/staff/";
	}

	/**
	 * 删除一个数据
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		System.out.println("delete: " + id);

		Db.delete(id);

		return "redirect:/staff/";
	}

	/**
	 * 编辑一个特定的数据（转发到 edit.jsp）
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		System.out.println("edit: " + id);

		// 获得员工的详细信息
		Staff staff = Db.find(id);

		model.addAttribute("staff", staff);

		return "edit";
	}

	/**
	 * 更新一个特定的数据（重定向到 ／）
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, Staff staff) {
		System.out.println("update: " + id);
		System.out.println("update: " + staff.toString());

		Db.update(staff);

		return "redirect:/staff/";
	}

}
