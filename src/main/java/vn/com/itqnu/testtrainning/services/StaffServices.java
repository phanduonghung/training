package vn.com.itqnu.testtrainning.services;

import java.util.List;

import vn.com.itqnu.testtrainning.entity.Staff;


public interface StaffServices {
	public List<Staff> getAllStaff();
	
	public Staff getStaffById(Long id);
	
	public Staff createStaff(Staff staff);
	
	public Staff updateStaff(Long id, Staff staff);
	
	public void deleteStaff(Long id);
}
